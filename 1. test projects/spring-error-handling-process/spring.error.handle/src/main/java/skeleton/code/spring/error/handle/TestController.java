package skeleton.code.spring.error.handle;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test-ex")
    public String test() {
        throw new RuntimeException();
//        return "foo-foo ><";
    }

    @GetMapping("/request-ex")
    public String test2(HttpServletResponse response) throws IOException {
        response.sendError(407);
        return "boo boo ><";
    }

    @GetMapping("/path-var/{num}")
    public Integer pathVar(@PathVariable Integer num) {
        log.info("#num = {}", num);
        return 33;
    }

    @GetMapping("/http-entity")
    public String httpEntity(HttpEntity entity, Integer num) {
        return "entity !";
    }

    @GetMapping("/response-ex")
    public String responseStatusError() {
        throw new CustomResponseStatusException();
    }

    @GetMapping("/local-date-time")
    public LocalDateTime localDateTime() {
        return LocalDateTime.now();
    }
}
