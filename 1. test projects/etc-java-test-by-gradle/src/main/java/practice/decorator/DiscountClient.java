package practice.decorator;

public class DiscountClient {

    private DiscountPolicy discountPolicy;

    public DiscountClient(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public double discount(int amount) {
        return discountPolicy.discount((double) amount);
    }
}
