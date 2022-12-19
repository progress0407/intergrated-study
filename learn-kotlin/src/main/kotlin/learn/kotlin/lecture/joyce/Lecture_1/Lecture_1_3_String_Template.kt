package learn.kotlin.lecture.joyce.Lecture_1

/**
 * 3. 문자열 템플릿
 */
fun main() {
    val name = "Joyce"
    println("my name is $name")
    println("my name is ${name}")
    val lastName = "Hong"
    println("my name is ${name + lastName}, I'm 23")

    println("this is 2\$") // 이스케이프 문자
}