package whiteship.studyhalae.lec8interface;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public interface CustomCalculator {

	default int addEvenNumbers(int... nums) {
		return add(x -> x % 2 == 0, nums);
	}

	default int addOddNumbers(int... nums) {
		return add(x -> x % 2 == 1, nums);
	}

	private int add(IntPredicate predicate, int... nums) {
		return IntStream.of(nums)
			.filter(predicate)
			.sum();
	}
}
