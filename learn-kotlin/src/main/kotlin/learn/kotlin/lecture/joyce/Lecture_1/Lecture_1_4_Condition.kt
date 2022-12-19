package learn.kotlin.lecture.joyce.Lecture_1

/**
 * 4. 조건식
 *
 * Expression vs Statement
 *
 * Expression: 표현식: 뽀짝뽀짝해서 값을 만듦. 모든 함수, 조건문
 * Statement: 값을 반환하지 않음. 명령을 지시.
 */
fun main() {
    println(maxBy(3, 4))
    println(maxBy2(3, 4))
    println(checkNum(15))
}

fun maxBy(a: Int, b: Int): Int {

    if (a > b) {
        return a
    } else {
        return b
    }
}

/**
 * 자바와 달리
 * 삼항 연산자가 없다
 * a>b ? a:b
 *
 * 자동 타입추론을 한다
 */
fun maxBy2(a: Int, b: Int) = if (a > b) a else b

fun checkNum(score: Int) {
    // 이때 when 은 Statement 로 사용
    when (score) {
        0 -> println("this is 0")
        1 -> println("this is 1")
        2, 3 -> println("this is 2 or 3")
        else -> println("I don't know") // 생략가능, 생략시 Unit 타입 반환
    }
}

/**
 * 조건절은 식이다!
 */

// 이때 when 은 Expression 으로 사용
fun checkNum2(score: Int) = when (score) {
    0 -> 0.0
    1 -> 100.0
    else -> score * 100 // 식으로 사용시 else 블럭을 무조건 붙여야 한다!
}

fun checkScore(score: Int) =
        when (score) {
            in 90..100 -> println("You are genius")
            in 10..80 -> println("Not Bad")
            else -> println("okay")
        }