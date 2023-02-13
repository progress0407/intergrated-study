package learn.kotlin.racingcar.domain

fun List<Car>.move() {

    for (car in this) {
        car.move()
    }
}

fun List<Car>.winners(): List<Car> =
    this.stream()
        .filter { it.position >= 5 }
        .sorted(compareBy { it.name })
        .toList()

fun List<Car>.hasWinner(): Boolean =
    this.winners()
        .isNotEmpty()

