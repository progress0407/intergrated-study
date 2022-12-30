package learn.kotlin.lecture.joyce.lecture_1

/**
 * 2. val vs var
 *
 * var 가변
 * val 불변
 */
fun main() {

    val a: Int = 10
//    a = 100 // compile error!
    var b: Int = 9
    b = 50

    /**
     * 타입 생략 가능
     */
    val c = 100
    var d = 100

    var name = "joyce"
//    name = 5 // 코틀린은 젇적 타입 언어!

    /**
     * 타입이 선언되지 않으면 할당 불가!
     */
//    val e  // compile error!
    val e: String
    e = "philz"
}