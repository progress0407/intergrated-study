package spring.tps;

import static java.lang.System.err;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Tps_ApiCaller_v1 {

    private static int errorCount = 0;
    private static final int wholeTrialCount = 1300;

    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(final String... args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < wholeTrialCount; i++) {
            threads.add(new RequestThread());
        }
        for (Thread thread : threads) {
            thread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        out.println("\n\n");
        out.println(wholeTrialCount + "개의 요청 중 ");
        out.println("---------------------------");
        out.println(errorCount + "개 실패 ");
    }

    private static String getRequest() {
        ResponseEntity<String> entity = null;
        try {
            restTemplate.getForEntity("http://localhost:8080/test/resource", String.class);
            return "success";
        } catch (Exception ex) {
            errorCount++;
            err.println(ex.getMessage());
            return "error";
        }
    }

    public static class RequestThread extends Thread {

        @Override
        public void run() {
            getRequest();
        }
    }
}
