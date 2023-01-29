package spring.tps;

import static java.lang.System.err;
import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class TpsTestAppTest {
    private static RestTemplate restTemplate = new RestTemplate();

    @DisplayName("api call")
    @Test
    void api_call() {
        String request = getRequest();
        out.println("request = " + request);
    }

    @DisplayName("api call - 2")
    @Test
    void api_call_2() {
        getRequest();
        getRequest();
        getRequest();
    }

    @DisplayName("concurrent call")
    @Test
    void concurrent_call() {
        // fail
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> future = executorService.scheduleAtFixedRate(getRequestRn(), 0, 10,
                TimeUnit.MILLISECONDS);
    }

    private Runnable getRequestRn() {
        return () -> getRequest();
    }

    private String getRequest() {
        return restTemplate.getForObject("http://localhost:8080/test/resource", String.class);
    }

    @DisplayName("concurrent call - 2")
    @Test
    void concurrent_call_2() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> getRequest())
                        .handle(handleResultOrException());

        out.println(future.get());
        out.println("hello");
    }

    private BiFunction<String, Throwable, String> handleResultOrException() {
        return (result, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return "Error !";
            }
            out.println("result = " + result);
            return result;
        };
    }

    @DisplayName("concurrent call - 3")
    @Test
    void concurrent_call_3() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(new GetRequestRunnableWithCompleteFuture()));
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    @DisplayName("concurrent call - 4")
    @Test
    void concurrent_call_4() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(getRequestRn()));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

    class GetRequestRunnableWithCompleteFuture implements Runnable {

        @Override
        public void run() {
            CompletableFuture<String> future =
                    CompletableFuture.supplyAsync(() -> getRequest())
                            .handle(handleResultOrException());

            String futureResult = null;
            try {
                futureResult = future.get();
            } catch (InterruptedException | ExecutionException e) {
                err.println("Error Occurred !");
                e.printStackTrace();
            }

            out.println("future result = " + futureResult);
        }
    }

    public static void main(final String... args) {

        int wholeTrialCount = 300;

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

        out.printf("%s 요청 건 중 %s 개 장애 발생", wholeTrialCount, errorCount);
    }

    private static int errorCount = 0;

    public static class RequestThread extends Thread {

        @Override
        public void run() {
            ResponseEntity<String> entity = null;
            try {
                entity = restTemplate.getForEntity("http://localhost:8080/test/resource", String.class);
                out.println(entity.getStatusCode());
                out.println(entity.getBody());
            } catch (Exception ex) {
                errorCount++;
                ex.printStackTrace();
            }
        }
    }
}