package test.spring.objectgenerator;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/obj")
public class ObjectGenerationController {

    @GetMapping("/gen-string")
    public String generate_string(int num) {

        for (int i = 0; i < num; i++) {
            new String(UUID.randomUUID().toString());
        }

        return "generated ! ";
    }

    @GetMapping("/gen-th")
    public String generate_thread(int num) {

        for (int i = 0; i < num; i++) {
            new GeneratedThread();
        }

        return "generated ! ";
    }

    @GetMapping("/gen-optional")
    public String generate_optional(int num) {

        var list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            var optional = Optional.ofNullable(new String(UUID.randomUUID().toString()));
            list.add(optional);
        }

        return "generated ! ";
    }

    private static class GeneratedThread extends Thread {

        @Override
        public void run() {
            UUID.randomUUID().toString();
        }
    }
}
