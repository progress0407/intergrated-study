package learn.kotlin.racingcar.domain

class Cars {
}

fun List<Car>.move() {
    for (car in this) {
        car.move()
    }
}