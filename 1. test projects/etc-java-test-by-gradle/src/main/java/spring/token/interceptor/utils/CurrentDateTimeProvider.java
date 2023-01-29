package spring.token.interceptor.utils;

import java.time.LocalDateTime;

public class CurrentDateTimeProvider implements DateTimeProvider{

    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }
}
