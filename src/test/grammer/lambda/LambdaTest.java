package test.grammer.lambda;

public class LambdaTest {
	public static void main(String[] args) {
		Foo foo = x -> x + 5;
		Boo boo = x -> x * 2;
		foo.doo(10);
	}

	@FunctionalInterface
	interface Foo {
		int doo(int x);
	}

	@FunctionalInterface
	interface Boo {
		int doo(int x);
	}
}
