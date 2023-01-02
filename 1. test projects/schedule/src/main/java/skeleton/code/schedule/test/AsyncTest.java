package skeleton.code.schedule.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AsyncTest {

    private final AsyncTestTasker asyncTestTasker;

    @RequestMapping("/async")
    public void print() {
        System.out.println("1 = " + 1);
        asyncTestTasker.process();
        System.out.println("2 = " + 2);
    }
}
