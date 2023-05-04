package practice.spring.data.jpa.doing;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleJavaTest {

    @DisplayName("date to epoch time")
    @Test
    void test_1() {
        Date date = new Date();
        long epoch = date.getTime();
        System.out.println(epoch);
        // 1 6570 8462 9958
    }

    @DisplayName("")
    @Test
    void test1() throws InterruptedException {

        getEpochTimes(); // 1 6571 4237 6766
        Thread.sleep(1000L);
        getEpochTimes(); // 1 6571 4237 7778

    }

    private void getEpochTimes() {
        ZonedDateTime zdt = LocalDateTime.now().atZone(ZoneId.of("America/Los_Angeles"));
        long millis = zdt.toInstant().toEpochMilli();
        System.out.println("millis = " + millis);
    }

    @DisplayName("")
    @Test
    void Son_reflect_() {
        Son son = new Son("philz", "04.07");
        System.out.println("son = " + son);
    }

    private static class Son extends Parent {
        private String name;

        public Son(String name, String createdAt) {
            super(createdAt);
            this.name = name;
        }

        @Override
        public String toString() {
            return "Son{" +
                    "name='" + name + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    '}';
        }
    }


    private static class Parent {
        protected String createdAt;

        public Parent(String createdAt) {
            this.createdAt = createdAt;
        }

        @Override
        public String toString() {
            return "Parent{" +
                    "createdAt='" + createdAt + '\'' +
                    '}';
        }
    }
}
