package learn.kotlin.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.Random

class CarTest {

    @Test
    fun `자동차는 move를 하면 위치가 1 증가한다`() {
        // given
        val car = Car("philz", CarFixedMovingStrategy())

        // when
        car.move()

        // then
        assertThat(car.position).isEqualTo(1);
    }

}
