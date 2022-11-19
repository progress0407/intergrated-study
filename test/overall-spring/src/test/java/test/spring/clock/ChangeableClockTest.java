package test.spring.clock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChangeableClockTest {

    @DisplayName("시간을 변경할 수 있다.")
    @Test
    void time_1() {
        final ChangeableClock clock = new ChangeableClock();
        clock.fixedClock(LocalDateTime.of(2020, 1, 1, 1, 1));
        assertThat(clock.getDateTime()).isEqualTo(LocalDateTime.of(2020, 1, 1, 1, 1));
    }

    @DisplayName("현재 시간을 조회할 수 있다")
    @Test
    void time_2() {
        final ChangeableClock clock = new ChangeableClock();
        clock.refreshClock();
        assertThat(clock.getDateTime()).isCloseTo(LocalDateTime.now(), within(1L, ChronoUnit.SECONDS));
    }

}