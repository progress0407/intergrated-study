package learn.kotlin.racingcar.domain

class Car(val name: String, private val movingStrategy: CarMovingStrategy) {

    var position: Int = 0

    fun move() {
        if (movingStrategy.isMoveStatus()) {
            position++
        }
    }
}