package learn.kotlin.temp

fun main() {
    val str = "ABC"

    if (fun1() && fun2()) {
        println("hello")
    }

    val list = listOf(1,2,3)
    println("1 in list = ${1 in list}")
    println("(1 in list) == true = ${(1 in list) == true}")
    println("1 is Number = ${1 is Number}")

    val intRange: IntRange = 1..10
    println("intRange = ${intRange}")
}

fun fun1(): Boolean {
//    TODO("h1 Not yet implemented")
    println("fun 1")
    return false
}

fun fun2(): Boolean {
//    TODO("h2 Not yet implemented")
    println("fun 2")
    return true
}

