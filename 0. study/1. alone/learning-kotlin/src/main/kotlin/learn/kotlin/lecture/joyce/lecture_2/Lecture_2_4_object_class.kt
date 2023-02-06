package learn.kotlin.lecture.joyce.lecture_2

/**
 * Object Class
 * Singleton Pattern!
 */
object CarFactory {
    val cars = mutableListOf<Car>()

    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower:Int)

fun main() {
    val car1 = CarFactory.makeCar(100)
    val car2 = CarFactory.makeCar(200)

    println("car1 = $car1")
    println("car2 = $car2")
    println("CarFactory.cars.size = $CarFactory.cars.size") // 실수 조심!
    println("CarFactory.cars.size.toString() = ${CarFactory.cars.size.toString()}")
    println("CarFactory.cars.size = ${CarFactory.cars.size}")
}
