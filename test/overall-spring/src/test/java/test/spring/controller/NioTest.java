package test.spring.controller;

import static java.lang.System.out;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

class NioTest {

    @Test
    void nio() {
        final WebClient webClient = WebClient.create("http://localhost:8080");

        final ResponseSpec responseSpec =
                webClient.get()
                        .uri("/nio/req")
                        .retrieve();

        final Mono<String> mono = responseSpec.bodyToMono(String.class);

        out.println("mono.block() = " + mono.block());
    }

    @Test
    void nio2() {
        final ExecutorService threadPool = Executors.newFixedThreadPool(4);

        final WebClient webClient = WebClient.create("http://localhost:8080");

        final Mono<String> mono = mono(webClient);

        threadPool.execute(() -> out.println("mono.block() = " + mono.block()));
    }

    private Mono<String> mono(final WebClient webClient) {
        return webClient.get()
                .uri("/nio/req")
                .retrieve().bodyToMono(String.class);
    }

    @DisplayName("qwe")
    @Test
    void qwe() throws InterruptedException {

        out.println("### Thread.currentThread().getName() = " + Thread.currentThread().getName());

        final Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            out.println("### Thread.currentThread().getName() = " + Thread.currentThread().getName());
        });

        thread.start();

        thread.join();
    }
}