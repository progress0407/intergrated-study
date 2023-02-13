package learn.kotlin.racingcar.domain

import learn.kotlin.racingcar.domain.moviing.CarRandomMovingStrategy

data class GameMemory(
    var gameState: GameState = GameState.INPUT,
    val carMovingStrategy: CarRandomMovingStrategy = CarRandomMovingStrategy(),
    val cars: MutableList<Car> = mutableListOf()
) {

    fun inputAllCars(cars: List<Car>) {

        this.cars.addAll(cars)
    }

    fun nextTurn() {

        gameState = gameState.nextState()
    }

    fun isEndGame(): Boolean =
        cars.hasWinner()
}
