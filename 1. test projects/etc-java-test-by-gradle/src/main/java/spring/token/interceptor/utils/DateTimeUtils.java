package spring.token.interceptor.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class DateTimeUtils {

    public static Date convertDateFrom(LocalDateTime dateTime) {
        return Timestamp.valueOf(dateTime);
    }

}
