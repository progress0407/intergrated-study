package spring.tps;

import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class TpsTestApp {

    public static void main(final String... args) {
        SpringApplication.run(TpsTestApp.class, args);
    }

    @GetMapping("/test/resource")
    @SneakyThrows
    public String test() {
        log.info("ResourceController.test");
        TimeUnit.MILLISECONDS.sleep(1_000);
        return "ok";
    }
}
