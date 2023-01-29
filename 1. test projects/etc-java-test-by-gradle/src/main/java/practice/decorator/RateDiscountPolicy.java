package practice.decorator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RateDiscountPolicy implements DiscountPolicy{

    private DiscountPolicy discountPolicy;

    @Override
    public double discount(double amount) {
        if (discountPolicy != null) {
            return discountPolicy.discount(amount) * 0.7;
        }
        return amount * 0.7;
    }
}
