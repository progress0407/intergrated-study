package practice.decorator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class FixedDiscountPolicy implements DiscountPolicy {

    private DiscountPolicy discountPolicy;

    @Override
    public double discount(double amount) {
        if (discountPolicy != null) {
            return discountPolicy.discount(amount) - 300;
        }
        return amount - 300;
    }
}
