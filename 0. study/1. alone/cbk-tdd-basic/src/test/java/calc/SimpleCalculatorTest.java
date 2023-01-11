package calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleCalculatorTest {

    @Test
    @DisplayName("0 + 0 는 0이다")
    void test_sum_1() {
        // given & when
        int result = SimpleCalculator.add(0, 0);

        // then
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("3 + 2 는 5이다")
    void test_sum_2() {
    	// given & when
        int result = SimpleCalculator.add(3, 2);

    	// then
        Assertions.assertEquals(5, result);
    }
}
