package learn.kotlin.temp

import java.lang.Math.pow
import kotlin.math.pow
import kotlin.math.sqrt

data class Point(val x: Int, val y: Int) {

    operator fun invoke() {
        println("invoke !!")
    }

    operator fun plus(other: Point): Point {

        return Point(this.x + other.x, this.y + other.y)
    }

    operator fun minus(other: Point): Point {

        return Point(this.x - other.x, this.y - other.y)
    }

    operator fun times(n: Int): Point {

        return Point(this.x*n,this.y * n)
    }

/*
    // receiver must be a supertype of the return type
    operator fun inc(): Unit {

    }
*/

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    override fun toString(): String {
        return "Point(x=$x, y=$y)"
    }

    operator fun compareTo(other: Point): Int {
        return this.distance().compareTo(other.distance())
    }

    private fun distance(): Double {
        return sqrt(x.toDouble().pow(2.0) + y.toDouble().pow(2.0))
    }

    operator fun inc(): Point {
        TODO("Not yet implemented")
        return Point(this.x + 1, this.y + 1)
    }
}

fun main() {
    // destructing declaration
    val p1 = Point(1, 3)
    val p2 = Point(3, 1)

    println("p1 + p2 = ${p1 + p2}")
    println("p1 - p2 = ${p1 - p2}")
    println("p1 * 2 = ${p1 * 2}")
    println("2 * p2 = ${2 * p1}")

    println("p1 > p2 = ${p1 > p2}")
    println("p1 >= p2 = ${p1 >= p2}")

    var point = Point(1, 4)
    point()

    val nextPoint = point++
    println("nextPoint = ${nextPoint}")

    println("point = ${point}")
}

operator fun Int.times(point: Point): Point {
    return point * this
}
