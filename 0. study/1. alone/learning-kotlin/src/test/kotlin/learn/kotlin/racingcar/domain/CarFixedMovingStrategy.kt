package learn.kotlin.racingcar.domain

import learn.kotlin.racingcar.domain.moviing.CarMovingStrategy

class CarFixedMovingStrategy : CarMovingStrategy {

    private var isMoveStatus: Boolean = true

    override fun isMoveStatus(): Boolean = isMoveStatus

    fun changeMoveStatus(moveStatus: Boolean) {

        this.isMoveStatus = moveStatus
    }
}