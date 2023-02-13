package learn.kotlin.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차들이 움직이면 움직인다`() {
        // given
        val car1 = Car("philz", CarFixedMovingStrategy())

        val car2movingStrategy = CarFixedMovingStrategy()
        car2movingStrategy.changeMoveStatus(false)

        val car2 = Car("foo", car2movingStrategy)

        val cars = listOf(car1, car2)

        // when
        cars.move()

        // then
        assertThat(car1.position).isEqualTo(1)
        assertThat(car2.position).isEqualTo(0)
    }

    @Test
    fun `5번 이동했을 시 우승자를 선출한다`() {
        // given
        val philzCar = Car("philz", CarFixedMovingStrategy())
        val aooCar = Car("aoo", CarFixedMovingStrategy())
        val booCar = Car("boo", CarFixedMovingStrategy())

        val cars = listOf(philzCar, aooCar, booCar)

        for (index in 1..5) {
            cars.move()
        }

        // when
        val winners = cars.winners()

        // then
        assertThat(winners.size).isEqualTo(3)
        assertThat(winners).containsExactly(aooCar, booCar, philzCar)
    }
}
