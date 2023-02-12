package learn.kotlin.racingcar.domain

import java.util.Random

class CarRandomMovingStrategy : CarMovingStrategy {

    private val random = Random()

    override fun isMoveStatus(): Boolean {

        val randomNo = random.nextInt(10)

        if (randomNo in 0..3) {
            return false
        }
        return true
    }
}
