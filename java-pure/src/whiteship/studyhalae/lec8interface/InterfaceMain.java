package whiteship.studyhalae.lec8interface;

public class InterfaceMain {
	public static void main(String[] args) {
		// test();
		test2();
	}

	private static void test2() {
		HelloJoinMember helloJoinMember = new HelloJoinMember();
		helloJoinMember.preJoin();
	}

	private static void test() {
		CustomCalculatorImpl calculator = new CustomCalculatorImpl();
		int[] nums = {1, 2, 3, 4};
		// odd sum = 4
		// even sum = 6
		int oddSum = calculator.addOddNumbers(nums);
		System.out.println("oddSum = " + oddSum);
		int evenSum = calculator.addEvenNumbers(nums);
		System.out.println("evenSum = " + evenSum);
	}
}
