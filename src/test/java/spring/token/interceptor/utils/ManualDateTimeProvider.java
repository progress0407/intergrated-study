package spring.token.interceptor.utils;

import java.time.LocalDateTime;

/**
 * 수동으로 LocalDateTime 을 변경할 수 있는 클래스
 */
public class ManualDateTimeProvider implements DateTimeProvider {

    private LocalDateTime dateTime;

    public ManualDateTimeProvider() {
    }

    public ManualDateTimeProvider(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public LocalDateTime get() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
