package spring.token.interceptor.utils;

import java.time.LocalDateTime;

public interface DateTimeProvider {
    LocalDateTime get();
}
