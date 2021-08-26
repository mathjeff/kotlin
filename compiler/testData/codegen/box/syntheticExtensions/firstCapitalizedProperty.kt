// TARGET_BACKEND: JVM

// FILE: main.kt

abstract class Parent<K>
abstract class DefaultParent<K, X> : Parent<K>()
abstract class TableDerived<K : CharSequence> : DefaultParent<K, Int>()

fun foo(): Parent<out CharSequence> = TODO()

fun box(): String {
    val w = foo() as? TableDerived ?: return "fail 1"
    return "fail"
}
