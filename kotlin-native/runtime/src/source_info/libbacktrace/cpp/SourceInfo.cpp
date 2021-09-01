/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

#include "SourceInfo.h"
#include "backtrace.h"
#include "KAssert.h"

#include <cstring>
#include <memory>

#ifdef KONAN_WINDOWS
#include <windows.h>
#include <psapi.h>

static std::unique_ptr<wchar_t> getFileNameW() {
    DWORD bufferLength = 64;
    std::unique_ptr<wchar_t> buffer;
    for (;;) {
        buffer.reset(static_cast<wchar_t*>(malloc(sizeof(wchar_t) * bufferLength)));
        RuntimeAssert(buffer, "Out of memory");

        DWORD res = GetModuleFileNameW(nullptr, buffer.get(), bufferLength);
        if (res != 0 && res < bufferLength) {
            fprintf(stderr, "Detected filename: %ls\n", buffer.get());
            return buffer;
        }
        const int MAX_BUFFER_SIZE = 32768; // Max path length + 1.
        if (res == bufferLength && bufferLength < MAX_BUFFER_SIZE) {
            // Buffer is too small, continue:
            bufferLength *= 2;
            continue;
        }

        return nullptr;
    }
}
static const char* getFileName() {
    auto wbuffer = getFileNameW();
    std::unique_ptr<char> buffer;
    int bufferLength = wcslen(wbuffer.get());
    for (;;) {
        buffer.reset(static_cast<char*>(malloc(sizeof(char) * bufferLength)));
        RuntimeAssert(buffer, "Out of memory");

        int converted = wcstombs(buffer.get(), wbuffer.get(), bufferLength);
        if (converted <= 0) {
            return nullptr;
        }
        if (converted < bufferLength) {
            fprintf(stderr, "Detected filename converted: %s\n", buffer.get());
            return buffer.release();
        }
        const int MAX_BUFFER_SIZE = 32768 * 2; // Max path length + 1.
        if (converted == bufferLength && bufferLength < MAX_BUFFER_SIZE) {
            // Buffer is too small, continue:
            bufferLength *= 2;
            continue;
        }
        return nullptr;
    }
}
static uintptr_t getModuleBase() {
    MODULEINFO module_info;
    memset(&module_info, 0, sizeof(module_info));
    if (GetModuleInformation(GetCurrentProcess(), GetModuleHandle(nullptr), &module_info, sizeof(module_info))) {
        return reinterpret_cast<uintptr_t>(module_info.lpBaseOfDll);
    }
    return 0;
}
uintptr_t getAddressShift() {
    return 0;
    static auto shift = - getModuleBase();
    return shift;
}
#else
static const char* getFileName() { return nullptr; }
uintptr_t getAddressShift() { return 0; }
#endif

extern "C" int Kotlin_getSourceInfo_libbacktrace(void* addr, SourceInfo *result, int result_size) {
    if (result_size == 0) return 0;
    fprintf(stderr, "getSourceInfo(%p), Kotlin_getSourceInfo_libbacktrace = %p, shift = %llx, shifted Kotlin_getSourceInfo_libbacktrace = %llx\n",
    addr, Kotlin_getSourceInfo_libbacktrace, (unsigned long long)getAddressShift(), (unsigned long long)(Kotlin_getSourceInfo_libbacktrace) + getAddressShift());
    /**
     * This is hack for better traces.
     * backtrace function returns address after call instruction, and address detection need call instruction itself
     * For honest solution, we should distinguish backtrace symbols got from signal handlers frames, ordinary frames,
     * and addresses got from somewhere else. But for now, we assume all addresses are ordinary backtrace frames.
     */
    addr = reinterpret_cast<void*>(reinterpret_cast<uintptr_t>(addr) - 1);
    auto ignore_error = [](void* vp, const char* s, int x){
        fprintf(stderr, "I have an error void* = %p, s = %s, x = %d\n", vp, s, x);
    };
    static auto state = backtrace_create_state(getFileName(), 1, ignore_error, nullptr);
    fprintf(stderr, "state = %p\n", state);
    if (!state) return 0;
    struct callback_arg_t {
        SourceInfo *result;
        int result_ptr;
        int result_size;
        int total_count;
    } callback_arg;
    callback_arg.result = result;
    callback_arg.result_ptr = 0;
    callback_arg.result_size = result_size;
    callback_arg.total_count = 0;
    auto process_line = [](void *data, uintptr_t pc, const char *filename, int lineno, int column, const char *function) -> int {
        fprintf(stderr, "got line data = %p, pc = %llx, filename = %s, lineno = %d, column = %d, function = %s, sizeof(pc) = %ld\n",
        data, (unsigned long long)pc, filename, lineno, column, function, sizeof(pc));
        auto &callback_arg = *static_cast<callback_arg_t*>(data);
        // Non-inlined frame would be last one, it's better to have it, then intermediate ones
        if (callback_arg.result_ptr == callback_arg.result_size) {
            callback_arg.result_ptr--;
        }
        auto &info = callback_arg.result[callback_arg.result_ptr];
        info.setFilename(filename);
        info.lineNumber = lineno;
        info.column = column;
        callback_arg.result_ptr++;
        callback_arg.total_count++;
        // Let's stop at least at some point
        // Probably, this can happen only if debug info is corrupted
        return callback_arg.total_count > callback_arg.result_size * 10;
    };
    backtrace_pcinfo(state, reinterpret_cast<uintptr_t>(addr) + getAddressShift(), process_line, ignore_error, &callback_arg);
    return callback_arg.total_count;
}