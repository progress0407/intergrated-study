package test.grammer.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {
	public static void main(String[] args) {
		Function<Integer, Integer> foo = x -> x + 100;
		Function<Integer, String> boo = String::valueOf;
		Function<Integer, String> bar = foo.andThen(boo);
		System.out.println("bar.apply(7) = " + bar.apply(7));

		Supplier<String> supplier = () -> "hello world";
		System.out.println("supplier = " + supplier.get());

		Consumer<String> consumer = (str) -> System.out.println(str + " " + str + " ");
		consumer.accept("hello");
	}

	@FunctionalInterface
	interface FnFoo {
		Integer call(Integer in);
	}
}
