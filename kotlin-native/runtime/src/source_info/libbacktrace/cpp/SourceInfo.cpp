/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

#include "SourceInfo.h"
#include "backtrace.h"

#include <cstring>

extern "C" int Kotlin_getSourceInfo_libbacktrace(void* addr, SourceInfo *result, int result_size) {
    /**
     * This is hack for better traces.
     * backtrace function returns address after call instruction, and address detection need call instruction itself
     * For honest solution, we should distinguish backtrace symbols got from signal handlers frames, ordinary frames,
     * and addresses got from somewhere else. But for now, we assume all addresses are ordinary backtrace frames.
     */
    addr = reinterpret_cast<void*>(reinterpret_cast<uintptr_t>(addr) - 1);
    auto ignore_error = [](void*, const char*, int){};
    static auto state = backtrace_create_state(nullptr, 1, ignore_error, nullptr);
    if (!state) return 0;
    struct callback_arg_t {
        SourceInfo *result;
        int result_ptr;
        int result_size;
    } callback_arg;
    callback_arg.result = result;
    callback_arg.result_ptr = 0;
    callback_arg.result_size = result_size;
    auto process_line = [](void *data, uintptr_t pc, const char *filename, int lineno, int column, const char *function) -> int {
        auto &callback_arg = *static_cast<callback_arg_t*>(data);
        if (callback_arg.result_ptr < callback_arg.result_size) {
            auto &info = callback_arg.result[callback_arg.result_ptr];
            info.setFilename(filename);
            info.lineNumber = lineno;
            info.column = column;
            callback_arg.result_ptr++;
        }
        return callback_arg.result_ptr == callback_arg.result_size;
    };
    backtrace_pcinfo(state, reinterpret_cast<uintptr_t>(addr), process_line, ignore_error, &callback_arg);
    return callback_arg.result_ptr;
}