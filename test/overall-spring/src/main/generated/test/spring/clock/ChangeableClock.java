package test.spring.clock;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.Getter;

@Getter
public class ChangeableClock {

    private LocalDateTime dateTime;
    private static final ZoneId zoneId = ZoneId.systemDefault();

    public void fixedClock(LocalDateTime dateTime) {
        final Instant fixedInstant = dateTime.atZone(zoneId).toInstant();
        final Clock clock = Clock.fixed(fixedInstant, zoneId);
        this.dateTime = LocalDateTime.now(clock);
    }

    public void refreshClock() {
        fixedClock(LocalDateTime.now());
    }
}
