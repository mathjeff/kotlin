// SKIP_DCE_DRIVEN
// RUN_PLAIN_BOX_FUNCTION
// INFER_MAIN_MODULE

// See KT-43783

// MODULE: nestedObjectExport
// FILE: lib.kt

@JsExport
class Abc {
    companion object AbcCompanion {
        fun xyz(): String = "Companion object method OK"

        val prop: String
            get() = "Companion object property OK"
    }
}

@JsExport
sealed class MyEnum(val name: String) {
    object A: MyEnum("A")
    object B: MyEnum("B")
    object C: MyEnum("C")
}

// FILE: test.js

function box() {
    const companionObject = nestedObjectExport.Abc.AbcCompanion;

    if (companionObject.xyz() != 'Companion object method OK') return 'companion object function failure';
    if (companionObject.prop != 'Companion object property OK') return 'companion object property failure';

    if (nestedObjectExport.MyEnum.A.name != 'A') return 'MyEnum.A failure';
    if (nestedObjectExport.MyEnum.B.name != 'B') return 'MyEnum.B failure';
    if (nestedObjectExport.MyEnum.C.name != 'C') return 'MyEnum.C failure';

    return 'OK';
}
