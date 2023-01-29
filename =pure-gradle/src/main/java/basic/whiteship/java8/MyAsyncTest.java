package basic.whiteship.java8;

import static java.lang.System.out;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyAsyncTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		out.println("----------1-----------");
		Future<String> helloFuture = executor.submit(() -> {
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return "Hello";
		});
		out.println("helloFuture.isDone() 0 = " + helloFuture.isDone());
		String hello = helloFuture.get();
		out.println("helloFuture.isDone() 1 = " + helloFuture.isDone());
		out.println("hello = " + hello);
		out.println("helloFuture.isDone() 2 = " + helloFuture.isDone());
		out.println("----------2-----------");
	}
}
