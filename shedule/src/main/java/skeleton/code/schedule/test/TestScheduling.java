package skeleton.code.schedule.test;

import static java.lang.System.out;

import java.time.LocalDateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 연습용 스케쥴링 서비스
 */
//@Component
public class TestScheduling {

    private int scheduled_1_sec = 0;
    private int scheduled_2_sec = 0;

    //    @Scheduled(cron = "*/1 * * * * MON-FRI")
    @Scheduled(fixedRate = 3000L)
    public void scheduled_1() {
        final LocalDateTime now = LocalDateTime.now();
        final int nowSecond = now.getSecond();
        final int timeDiff = nowSecond - scheduled_1_sec;
        scheduled_1_sec = nowSecond;
        out.printf("method 1: {%s} {%s}\n", now, timeDiff);
        out.println("method 1: " + Thread.currentThread().getName());
    }

    //    @Scheduled(cron = "*/10 * * * * MON-FRI")
    @Scheduled(fixedRate = 5000L)
    public void scheduled_2() {
        final LocalDateTime now = LocalDateTime.now();
        final int nowSecond = now.getSecond();
        final int timeDiff = nowSecond - scheduled_2_sec;
        scheduled_2_sec = nowSecond;
        out.printf("for 2: {%s} {%s}\n", now, timeDiff);
        out.println("method 2: " + Thread.currentThread().getName());
    }
}
