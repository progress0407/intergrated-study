package learn.kotlin.temp

import java.lang.IllegalArgumentException

fun main() {
//    main1()

    val boo = Boo()
    println("boo = ${boo}")
}

private fun main1() {
    val foo = Foo("hello", 31)
    println("foo's age = ${foo.age}")

    val boo = Foo("hello")
    println("boo's age = ${boo.age}")

    val bar = Foo()
    println("boo's age = ${bar.age}")

    println(Foo.something)
    Foo.Companion.something
}

private class Foo {

    val name: String
    var age: Int = 1

    companion object {
        val something: String = "this is something"
    }

    constructor() : this("성우짱")

    constructor(name: String) : this(name, 31)

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    init {
        println("this is init function !")

        if (age < 0) {
            throw IllegalArgumentException("age can not be negative")
        }
    }

    /*
        val age: Int = age
            get() {
                println("getter call !")
                return field
            }
    */
}

data class Boo(val name: String = "성우", val age: Int = 31)
