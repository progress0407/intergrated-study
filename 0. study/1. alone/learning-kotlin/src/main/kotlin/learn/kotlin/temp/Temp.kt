package learn.kotlin.temp

fun main() {
    val a = Person("hello", 55)
    val b = Person("hello", 552)

    println("== = ${a == b}")
    println("a === b = ${a === b}")
}

class Person(val name: String, private val age: Int = -1) {

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
