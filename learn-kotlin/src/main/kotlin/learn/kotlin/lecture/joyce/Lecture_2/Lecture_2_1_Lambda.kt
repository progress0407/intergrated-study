package learn.kotlin.lecture.joyce.Lecture_2

/**
 * 1. Lambda
 * 람다식은 우리가 마치 value처럼 다룰 수 있는 익명함수이다.
 * 1) 메서드의 파라미터로 넘겨줄 수 있다. fun maxBy(a: Int)
 * 2) return의 값으로 사용할 수 있다.
 *
 * 람다의 기본 정의
 * val lambdaName: Type = {args -> codeBody}
 */

// 정의역은 arg가 여러개 올 수 있기 때문에 소괄호로 묶어야 함
//val square: (Int) -> Int = { number -> number * number }
// 타입 추론이 된다
//val square = { number: Int -> number * number }
// 파라미터가 하나일 경우 it으로 반환할 수 있다
val square: (Int) -> Int = { it * it }


// 가장 마지막 줄이 반환값이 된다
val nameAge = { name: String, age: Int ->
    "my name is $name, I'm $age"
}

fun main() {
    // 람다 기본
    println(square(5))
    println(nameAge("philz", 99))


    // 확장 함수
    println("Domino".pizzaIsGreat())
    println(extendStringWithArg("ariana", 30))


    // 람다 Return
    println(calculateGrade(100))
    println(calculateGrade(1_000))


    // 람다를 표현하는 여러가지 방법
    val lambda = { number: Double ->
        number == 4.3213
    }
    println(invokeLambda(lambda))
    // 람다 리터럴: 변수 선언 없이 바로 중괄호로 표현
    println(invokeLambda({it > 3.22}))
    // 소괄호 생략 가능
    invokeLambda(){ it > 3.22 }
    println(invokeLambda { it > 3.22 })
}

/**
 * 확장 함수
 */
val pizzaIsGreat: String.() -> String = {
    // pizzaBrand
    "$this Pizza is the best!"
}

fun extendStringWithArg(name: String, age: Int): String {
    val introduceMySelf: String.(Int) -> String = { "I am $this and $it years old" }
    return name.introduceMySelf(age)
}

/**
 * 람다 Return
 */
val calculateGrade: (Int) -> String = {
    when (it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfact"
        else -> "error"
    }
}

/**
 * 람다를 표현하는 여러가지 방법
 */
fun invokeLambda(lambda: (Double) -> Boolean): Boolean {
    return lambda(5.2343)
}

/**
 * 익명 내부 함수-를 람다를 이용해서 간편하게 표현 가능한 경우
 *
 * 1. Kotlin Interface 가 아닌 Java Interface 여야 합니다
 * 2. 그 Interace 는 딱 하나의 Method 만 가져야 합니다
 *
 * ex) button.setOnClickListener {  }
 */