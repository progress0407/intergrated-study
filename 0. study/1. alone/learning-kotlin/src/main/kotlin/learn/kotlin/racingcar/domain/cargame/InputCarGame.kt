package learn.kotlin.racingcar.domain.cargame

import learn.kotlin.racingcar.domain.GameMemory
import learn.kotlin.racingcar.domain.Car
import java.util.*

class InputCarGame(gameMemory: GameMemory) : CarGame(gameMemory) {

    override fun execute() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        val scanner = Scanner(System.`in`)
        val inputLine = scanner.nextLine()
        val carNames = convertCarNames(inputLine)
        val cars = createCars(carNames)
        gameMemory.inputAllCars(cars)
    }

    private fun createCars(carNames: MutableList<String>) =

        carNames.map { name -> Car(name, gameMemory.carMovingStrategy) }
            .toList()

    private fun convertCarNames(line: String): MutableList<String> =

        line.split(",").stream()
            .map { it.trim() }
            .toList()
}