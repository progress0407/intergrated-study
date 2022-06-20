package basic.whiteship.java8;

import static java.lang.System.out;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import lombok.SneakyThrows;

class WhiteShipJava8ThreadMain {
    public static void main(String[] args) {
        // basicThread();
        // executeService();
//		future();
//        future2();
//        completableFuture();
        completableFuture2();
    }

    @SneakyThrows
    private static void future() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(1000L);
            return "hello";
        };

        Future<String> helloFuture = executorService.submit(hello);

        out.println("----- start -----");

        out.println(helloFuture.isDone());

        /**
         * true: 현재 진행중인 작업을 interrupt 하면서 종료
         * false:              -을 기다린다
         *
         * 일단 cancel 을 호출하면 가져올 수 없다
         */
        try {
            helloFuture.cancel(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//		String helloVal = helloFuture.get();
//		out.println("helloVal = " + helloVal);

        out.println(helloFuture.isDone());

        out.println("----- end -----");

        executorService.shutdown();
    }

    @SneakyThrows
    private static void future2() {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };

        Callable<String> philz = () -> {
            Thread.sleep(1000L);
            return "philz";
        };

        List<Callable<String>> callables = List.of(hello, java, philz);

/*
		List<Future<String>> futures = executorService.invokeAll(callables);
		for (Future<String> future : futures) {
			out.println("future value = " + future.get());
		}
*/
        String anyInvoke = executorService.invokeAny(callables);
        out.println("anyInvoke = " + anyInvoke);

        executorService.shutdown();
    }

    /**
     * 퓨쳐의 문제... 합치거나 예외처리하는게 까다롭다.
     * <p>
     * JS 처럼 비동기 스러운 코드를 작성하기 어려웠어, 그동안은...
     * <p>
     * 응답이 안오면... 캐시한 내용이나 그외 기본값을 줄 수 있다다
     **/
    @SneakyThrows
    private static void completableFuture() {
//		CompletableFuture<String> future = new CompletableFuture<>();
//		future.complete("keesun");
//		out.println(future.get());

//		CompletableFuture<String> future = CompletableFuture.completedFuture("swcho");
//		out.println(future);

//		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//			out.println("Hello " + Thread.currentThread().getName());
//		});
//		out.println(future.get());

//		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//			out.println("Hello " + Thread.currentThread().getName());
//			return "Hello";
//		}).thenApply((message) -> {
//			out.println(Thread.currentThread().getName());
//			return message.toUpperCase();
//		});

//		CompletableFuture.supplyAsync(() -> {
//			out.println("Hello " + Thread.currentThread().getName());
//			return "Hello";
//		}).thenRun(() -> {
//			out.println(Thread.currentThread().getName());
//		});

        // common-pool을 안 사용하고 싶다면
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenRunAsync(() -> {
            out.println(Thread.currentThread().getName());
        }, executorService);

        future.get();

        executorService.shutdown();
    }

    private static void completableFuture2() {
//        completableFutureCase1();
//        completableFutureCase2();
        // 예제 하나는 과하게 김...

//        completableFutureCase3();
        completableFutureCase4();
    }

    @SneakyThrows
    private static void completableFutureCase1() {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> result = hello.thenCompose(message -> getWorld(message));

        out.println(result.get());
    }

    @SneakyThrows
    private static void completableFutureCase2() {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            return "World";
        });

//        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> {
//            return h + " " + w;
//        });
//        out.println(future.get());

        CompletableFuture.anyOf(hello, world)
                .thenAccept((message) -> {
                    out.println(message);
                });

    }

    @SneakyThrows
    private static void completableFutureCase3() {
        boolean throwError = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            return "Hello";
        }).exceptionally(ex -> {
            out.println(ex);
            return "Error !";
        });

        out.println(hello.get());
    }

    @SneakyThrows
    private static void completableFutureCase4() {
        boolean throwError = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            return "Hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return "Error !";
            }
            return result;
        });

        out.println(hello.get());
    }

    private static CompletableFuture<String> getWorld(String message) {
        return CompletableFuture.supplyAsync(() -> {
            return message + " " + "World";
        });
    }

    private static void executeService() {
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // executorService.submit(() -> {
        // 	System.out.println("Thread " + Thread.currentThread().getName());
        // });
        // executorService.shutdown();

        // ExecutorService executorService = Executors.newFixedThreadPool(2);
        // executorService.submit(getRunnable("Hello"));
        // executorService.submit(getRunnable("philz"));
        // executorService.submit(getRunnable("swcho"));
        // executorService.submit(getRunnable("Java 8"));
        // executorService.submit(getRunnable("Concurrent"));

        // executorService.shutdown();

        out.println("#1 -------------------------");
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        out.println("#2 -------------------------");
        // executorService.schedule(getRunnable("Hello"), 500, TimeUnit.MILLISECONDS);
        // executorService.scheduleAtFixedRate(getRunnable("hi"), 2000, 500, TimeUnit.MILLISECONDS);
        out.println("#3 -------------------------");

    }

    private static Runnable getRunnable(String message) {
        // try {
        // 	Thread.sleep(100L);
        // } catch (InterruptedException e) {
        // 	e.printStackTrace();
        // }
        return () -> out.println(message + " " + Thread.currentThread().getName());
    }

    private static void basicThread() {

        Thread thread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            out.println("Thread: " + threadName);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalArgumentException();
            }
            out.println(threadName + " is now exit !");
        });
        thread.start();

        out.println("Hello ! : " + Thread.currentThread().getName());

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        out.println(thread + " is finished");
    }
}
