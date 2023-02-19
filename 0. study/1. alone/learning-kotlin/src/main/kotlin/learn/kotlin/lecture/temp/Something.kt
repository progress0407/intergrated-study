package learn.kotlin.lecture.temp

import java.lang.RuntimeException

fun main() {
//    destructingDeclarations()

//    elvisOperator()

    null_plus_null()
}

private fun null_plus_null() {
//    println("null + null = ${null + null}")

    val a: Int? = null
    val b: Int? = null
    val result: Int? = a?.plus(b)

    println("result = ${result}")
}

private fun elvisOperator() {
    val hello = null ?: "default"
    println("hello = ${hello}")

    val hello = null ?: run {
        println("Oops, name was not set!")
        throw RuntimeException("hello ex ~!")
    }
}

private fun destructingDeclarations() {
//    ex1()
//    ex2()
//    ex3()

    val (x, y, z) = Vec(3, 7, 5)
    println("x = ${x}")
    println("y = ${y}")
    println("z = ${z}")
}

private fun ex3() {
    val medals = mapOf(
        1 to "Gold",
        2 to "Silver",
        3 to "Bronze"
    )

    println("medals = ${medals}")

    for ((key, value) in medals) {
        println("key = ${key}")
        println("value = ${value}")
    }
}

private fun ex2() {
    val fruitBasket = listOf("Apple", "Banana", "Cherry")
    val (first, second, third, fourth) = fruitBasket
    println("third = ${third}")
    println("fourth = ${fourth}")
}

private fun ex1() {
    val pair = "Gold" to 1
    val (metal, placement) = pair
    println("pair = ${pair}")
}

class Vec(val x: Int, val y: Int, val z: Int) {

    operator fun component1(): Int {
        return x
    }

    operator fun component2(): Int {
        return y
    }

    operator fun component3(): Int {
        return z
    }
}