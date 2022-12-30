package learn.kotlin.lecture.joyce.lecture_1

/**
 * 1. 함수
 */
fun main() {
    println(println("hello"))
    println(helloWorld())
    println(add(3, 4))
    println(add2(3, 4))
}

/**
 * 반환 값이 없으면 void가 아닌 Unit이다
 */
fun helloWorld(): Unit {
    println("Hello World!")
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun add2(a: Int, b: Int) = a + b