package learn.kotlin.racingcar.domain.cargame

import learn.kotlin.racingcar.domain.GameMemory
import learn.kotlin.racingcar.domain.Car
import learn.kotlin.racingcar.domain.move
import learn.kotlin.racingcar.times

class RunningCarGame(gameMemory: GameMemory) : CarGame(gameMemory) {

    private val cars = gameMemory.cars

    override fun execute() {
        println("실행 결과")

        while (!gameMemory.isEndGame()) {
            cars.move()
            display(cars)
            Thread.sleep(400)
        }
    }

    private fun display(cars: List<Car>) {
        for (car in cars) {
            display(car)
        }
        println()
    }

    private fun display(car: Car) {
        val visualizedPosition = "-" * car.position
        println("${car.name}: $visualizedPosition")
    }
}