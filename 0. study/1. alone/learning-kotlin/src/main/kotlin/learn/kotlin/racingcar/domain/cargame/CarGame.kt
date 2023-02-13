package learn.kotlin.racingcar.domain.cargame

import learn.kotlin.racingcar.domain.GameMemory

abstract class CarGame(protected val gameMemory: GameMemory) {

    abstract fun execute()

    fun run() {

        execute()
        gameMemory.nextTurn()
    }
}