package learn.kotlin.lecture.joyce.lecture_1

/**
 * 7. Nullable / NonNull
 *
 * NPE: Null Pointer Exception
 *
 * Java에서는 런타임이 아닌 컴파일타임에 알 수 없다
 *
 * 코틀린에서는 컴파일시점에 잡아줄게!
 */
fun main() {

    var name: String = "joyce"
//    var nullName : String = null // null 대입 불가
    var nullName: String? = null // Nullable Type!
    var namneUpperCase = name.uppercase()
    var nullNameInUpperCase = nullName?.uppercase() // null 이면 null, 아니면 연산수행 및 반환

    /**
     * ?: 엘비스 연산자
     * 기본 값을 지정하고 싶을 때 사용
     * 없으면 이거 써!
     */
    val lastName: String? = null
    val fullName = name + " " + (lastName ?: "No Last Name")
    println("fullName = ${fullName}")

    /**
     * !!
     * 이거 null 아니야!
     * 절대로!
     */
    ignoreNulls("philz")
}

fun ignoreNulls(str: String?) {
//    val mNotNull: String = str // compile error!
    val mNotNull: String = str!! // 하늘이 두쪽 나도, 여기엔 null이 올 수 없는 상황이야!
    val upper = mNotNull.uppercase()

    val email: String? = "joycehongXXX@nana.vom"
    email?.let {
        println("my email is = ${it}")
    }
}