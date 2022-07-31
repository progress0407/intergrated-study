package skeleton.code.schedule.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTasker {

    @Async
    public void process() {
        System.out.println("--- processing something ---");
        delay();
        System.out.println("--- processing completed ! ---");
    }

    private void delay() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
