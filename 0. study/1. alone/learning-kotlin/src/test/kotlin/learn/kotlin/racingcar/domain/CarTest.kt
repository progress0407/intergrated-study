package learn.kotlin.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.Random

class CarTest {

    @Test
    fun `자동차는 움직인다`() {
        // given
        val car = Car(CarFixedMovingStrategy())

        // when
        car.move()

        // then
        assertThat(car.position).isEqualTo(1);
    }
}