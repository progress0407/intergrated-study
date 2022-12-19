package learn.kotlin.lecture.joyce.Lecture_2


// POJO, 모델이 되는 클래스

/**
 * 2. Data Class
 *
 * toString(), hashCode(), equals(), copy()
 */
data class Ticket(
        val companyName: String,
        val name: String,
        var date: String,
        var seatNumber: Int)

class TicketNormal(
        val companyName: String,
        val name: String,
        var date: String,
        var seatNumber: Int)

fun main() {
    val ticketA = Ticket("koreanAir", "PhilzCho", "2020-02-16", 8)
    val ticketNormal = TicketNormal("koreanAir", "PhilzCho", "2020-02-16", 8)

    println(ticketA)
    println(ticketNormal)
}