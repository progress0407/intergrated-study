package practice.decorator;

import org.junit.jupiter.api.Test;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

public class DecoratorTest {

    @Test
    void 꾸며달란_말이야_고정할인_먼저() {
        FixedDiscountPolicy fixedDiscountPolicy = new FixedDiscountPolicy();
        RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy(fixedDiscountPolicy);
        DiscountClient discountClient = new DiscountClient(rateDiscountPolicy);
        double discountedAmount = discountClient.discount(2000);
        // (2000 - 300) * 0.7
        assertThat(discountedAmount).isEqualTo(1190);
    }

    @Test
    void 꾸며달란_말이야_비율할인_먼저() {
        RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
        FixedDiscountPolicy fixedDiscountPolicy = new FixedDiscountPolicy(rateDiscountPolicy);
        DiscountClient discountClient = new DiscountClient(fixedDiscountPolicy);
        double discountedAmount = discountClient.discount(2000);
        // (2000 - 300) * 0.7
        assertThat(discountedAmount).isEqualTo(1100);
    }
}
