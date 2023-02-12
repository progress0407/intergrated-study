package learn.kotlin.lecture.choitaehyun.ch03_oop

fun main() {

    val animal = Animal("Foo", 31)

    println("animal = ${animal}")
}

// legCount: Int
data class Animal(protected val species: String,
             protected val legCount: Int) {

}