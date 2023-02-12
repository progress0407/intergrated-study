package learn.kotlin.racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차들은 움직인다`() {
        // givne
        val `philz-car` = Car("philz", CarFixedMovingStrategy())
        val `foo-car` = Car("foo", CarFixedMovingStrategy())
        val cars = listOf<Car>(`philz-car`, `foo-car`)

        // when
        cars.move()

        // then
        Assertions.assertThat(cars[0].position).isEqualTo(1)
        Assertions.assertThat(cars[1].position).isEqualTo(1)
    }
}