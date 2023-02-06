package learn.kotlin.lecture.joyce.lecture_2

/**
 * Companion Object
 * 자바의 static (메서드, 필드) 대신에 사용,
 */

class Book private constructor(val id: Int = 0, val name: String) {

    //    companion object {
    companion object BookFactory : IdProvider {

        private val myBookName = "animal farm"

        fun create() = Book(name = myBookName)
        override fun getId(): Int = 444
    }
}

interface IdProvider {
    fun getId(): Int
}

fun main() {
//    val book = Book.Companion.create()
    val book = Book.create()
    println("$book.id ${book.name}")


    val bookId = Book.BookFactory.getId()
    println("$bookId")
}