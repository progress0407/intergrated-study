package learn.kotlin.lecture.joyce

/*
class Human {

    val name = "philz"
    fun eatingCake() {
        println("this is so YUMMMYYY~~~~~~")
    }
}
*/

/**
 * 생성자 방식 초기화
 */
/*
// step 1
class Human constructor(name: String) {

    val name = name

    fun eatingCake() {
        println("this is so YUMMMYYY~~~~~~")
    }
}
*/

// step 2: name, move to constructor
//class Human constructor(val name: String) {

// step 3: can remove constructor keyword
//class Human(val name: String) {

// step 4: set default value
/*
class Human(val name: String = "Anonymous") {

    // 부 생성자
    constructor(name: String, age: Int): this(name) { // 주 생성자로부터 위임
        println("my name is ${name}, ${age}year's old")
    }

    // init code block running with primary constructor
    init {
        println("init code block with ${name}")
    }

    fun eatingCake() {
        println("this is so YUMMMYYY~~~~~~")
    }
}
*/

/**
 * 상속
 * 기본적으로 코틀린은 class와 메서드의 가시성은 final !
 */
open class Human(val name: String = "Anonymous", val age: Int = 0) {

    init {
        println("my name is ${name}, ${age}year's old")
    }

    init {
        println("init code block with $name")
    }

    fun eatingCake() {
        println("this is so YUMMMYYY~~~~~~")
    }

    open fun singASong() {
        println("lalala")
    }
}

class Korean : Human() {

    override fun singASong() {
        super.singASong()
        println("라라랄")
        println("my name is = $name")
    }
}

fun main() {

//    val human = Human("philz")
//    human.eatingCake()
//    println("this human's name is ${human.name}")


//    val mom = Human("Kuri", 52)
//    val mom = Human(age = 52, name = "Kuri")


    Korean().singASong()
}
