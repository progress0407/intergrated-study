package spring.tps;

import static java.lang.System.err;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Tps_ApiCaller_v2 {

    private static int errorCount = 0;
    private static final int wholeTrialCount = 1300;

    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(final String... args) {

        ExecutorService executorService = Executors.newFixedThreadPool(wholeTrialCount);

        List<CompletableFuture<String>> futures = IntStream.range(0, wholeTrialCount)
                .mapToObj(trialCount -> CompletableFuture.supplyAsync(() -> getRequest(), executorService)
                ).collect(Collectors.toList());

        Map<String, Long> resultMap = futures.stream()
                .parallel()
                .map(CompletableFuture::join)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        out.println("\n\n");
        out.println(wholeTrialCount + "개의 요청 중 ");
        out.println("---------------------------");
        for (Entry<String, Long> entry : resultMap.entrySet()) {
            out.printf("%s - %d 개\n", entry.getKey(), entry.getValue());
        }
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
}
