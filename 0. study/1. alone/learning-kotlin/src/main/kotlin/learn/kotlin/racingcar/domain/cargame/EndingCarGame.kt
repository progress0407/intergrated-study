package learn.kotlin.racingcar.domain.cargame

import learn.kotlin.racingcar.domain.GameMemory
import learn.kotlin.racingcar.domain.winners

class EndingCarGame(gameMemory: GameMemory) : CarGame(gameMemory) {

    private val cars = gameMemory.cars

    override fun execute() {

        val winnerNamesJoined = cars.winners().joinToString { it.name }
        println("${winnerNamesJoined}가 최종 우승했습니다.")
    }
}
