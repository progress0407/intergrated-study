package learn.kotlin.lecture.joyce.Lecture_1

/**
 * 6. For / While
 */
fun main() {
    val students = arrayListOf("joyce", "james", "jenny", "jennifer")

//    forStatement(students)
//    whileStatement()

//    for (withIndex in students.withIndex()) {
//        println("withIndex = ${withIndex}")
//    }

    for ((index, name) in students.withIndex()) {
        println("${index + 1}번째 학생: $name")
    }
}

private fun whileStatement() {
    var index = 0
    while (index < 10) {
        println("current index : ${index}")
        index++
    }
}

private fun forStatement(students: ArrayList<String>) {
    for (name in students) {
        println("${name}")
    }

    var sum: Int = 0
//    for (i in 1..10) {
//    for (i in 1..10 step 2) {
//    for (i in 10 downTo 1) { // 10 ~ 1
    for (i in 1 until 10) { // 1 ~ 9
        println("i = ${i}")
        sum += i
    }
    println("sum = ${sum}")
}