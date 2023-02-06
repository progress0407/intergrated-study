package learn.kotlin.temp

fun main() {
    val ints = mutableListOf<Int>(1, 2, 3, 5, 7, 9)
    val mappedInts = ints.overThan()

    println("mappedInts = ${mappedInts}")
}

fun List<Int>.overThan(): List<Int> {
    return this.filter { it > 5 }
}