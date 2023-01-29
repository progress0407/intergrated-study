package whiteship.java8to11.interfacelambda;

import java.util.function.Function;

public class Plus10NotLambda implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
