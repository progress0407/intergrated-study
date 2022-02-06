package basic.whiteship.java8;

import static java.lang.System.*;

import java.sql.Time;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WhiteShipJava8ThreadMain {
	public static void main(String[] args) {
		// basicThread();
		// executeService();
		future();
	}

	private static void future() {

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
