package learn.kotlin.racingcar.domain.integration

import learn.kotlin.racingcar.domain.Car
import learn.kotlin.racingcar.domain.CarFixedMovingStrategy
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarIntegrationTest {

    @Test
    fun `테스트 픽스쳐를 이용해서 자동차의 움직임을 제어할 수 있다자동차는 move를`() {
        val movingStrategy: CarFixedMovingStrategy = CarFixedMovingStrategy()
        val car = Car("philz", movingStrategy)

        car.move()
        Assertions.assertThat(car.position).isEqualTo(1);

        movingStrategy.changeMoveStatus(false)
        car.move()
        Assertions.assertThat(car.position).isEqualTo(1);

        movingStrategy.changeMoveStatus(true)
        car.move()
        Assertions.assertThat(car.position).isEqualTo(2);
    }
}