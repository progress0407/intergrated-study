package test.spring.nio.controller;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

class NioTest {

    Logger log = LoggerFactory.getLogger(NioTest.class);

    @DisplayName("RestTemplate으로 테스트")
    @Test
    void nio2() {
        final ExecutorService threadPool = Executors.newFixedThreadPool(3);

        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.getFor
        threadPool.execute(() -> );

        threadPool.awaitTermination(60, SECONDS);
    }

    @DisplayName("WebClient로 테스트")
    @Test
    void nio() throws InterruptedException {
        final ExecutorService threadPool = Executors.newFixedThreadPool(3);

        threadPool.execute(requestRunnable(1));

        threadPool.awaitTermination(60, SECONDS);
    }

    private Runnable requestRunnable(int trialNumber) {
        return () -> {
            try {
                requestRunnableInner(trialNumber);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    private void requestRunnableInner(int trialNumber) {
        WebClient webClient = WebClient.create("http://localhost:8080");
        for (int i = 1; i <= trialNumber; i++) {
            log.info("################### trialNumber {} #################", i);
            Mono<String> mono = request(webClient);
            mono.subscribe(this::log);
        }
    }

    private Mono<String> request(final WebClient webClient) {
        return webClient.get()
                .uri("/nio/req")
                .retrieve().bodyToMono(String.class);
    }

    private void log(final String response) {
        log.info("###############################################");
        log.info("### ThreadName |  {}", response);
        log.info("###############################################");
    }
}