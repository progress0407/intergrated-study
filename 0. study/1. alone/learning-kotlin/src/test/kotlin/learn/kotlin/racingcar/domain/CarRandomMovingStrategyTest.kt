package learn.kotlin.racingcar.domain

import learn.kotlin.racingcar.domain.moviing.CarRandomMovingStrategy
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.withinPercentage
import org.junit.jupiter.api.Test

class CarRandomMovingStrategyTest {

    val carRandomMovingStrategy: CarRandomMovingStrategy = CarRandomMovingStrategy()
    val `총 시행 횟수`: Int = 10000
    var `움직인 횟수`: Int = 0

    @Test
    fun `isMoveStatus()는 60%의 확률로 이동한다`() {
        for (i in 1..`총 시행 횟수`) {
            if (carRandomMovingStrategy.isMoveStatus()) {
                `움직인 횟수`++
            }
        }
        assertThat(100 * `움직인 횟수` / `총 시행 횟수`).isCloseTo(60, withinPercentage(5))
    }
}
