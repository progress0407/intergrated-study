package learn.kotlin.racingcar.domain

import learn.kotlin.racingcar.domain.moviing.CarMovingStrategy

class Car(val name: String, private val movingStrategy: CarMovingStrategy) {

    var position: Int = 0
        private set

    fun move() {
        if (movingStrategy.isMoveStatus()) {
            position++
        }
    }
}