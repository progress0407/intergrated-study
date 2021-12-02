package whiteship.studyhalae.lec8interface;

public class InterfaceMain {
	public static void main(String[] args) {
		// test1();
		// test2();
		test3();
	}

	private static void test3() {
		CustomCalculatorImpl calculator = new CustomCalculatorImpl();
		int[] nums = {1, 2, 3, 4};
		// odd sum = 4
		// even sum = 6
		int oddSum = calculator.addOddNumbers(nums);
		System.out.println("oddSum = " + oddSum);
		int evenSum = calculator.addEvenNumbers(nums);
		System.out.println("evenSum = " + evenSum);
	}

	private static void test2() {
		JoinImpl join = new JoinImpl();
		join.preJoin();
		join.afterJoin();
	}

	private static void test1() {
		// new Java8Impl().method();
		// new Java8Impl().defaultMethod();
		// Java8Interface.staticMethod();
		// new Java9Impl().defaultMethod();

		Java8Interface.staticMethod();
	}
}
