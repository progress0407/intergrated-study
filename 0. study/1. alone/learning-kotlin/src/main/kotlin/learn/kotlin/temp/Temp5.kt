package learn.kotlin.temp

fun main() {
    val bar = Bar("Hello World")
    println("bar = ${bar}")
}

class Bar(name: String) {

    val name: String = name
        get() = field.uppercase()
}
