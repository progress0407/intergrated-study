package learn.kotlin.lecture.joyce

/**
 * 5. Array and List
 *
 * Array
 * List  1. (Immutable) List 2. Mutable List
 */
fun main() {
    val array = arrayOf(1, 2, 3)
    val list = listOf(1, 2, 3)

    // Any type 으로 추론
    val array2 = arrayOf(1, "d", 3.4f)
    val list2 = listOf(1,"d", 11L)

    array2[0] = 3
//    list[0] = 2 // 못바꿔!
//    list.get()
//    var arrayList = arrayListOf<Int>()
    val arrayList = arrayListOf<Int>()
//    arrayList = arrayListOf<Int>() // 재할당 안됨!
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0] = 20
}