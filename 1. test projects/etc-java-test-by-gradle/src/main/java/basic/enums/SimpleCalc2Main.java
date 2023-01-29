package basic.enums;

import java.util.function.BiFunction;
import java.util.function.Function;

public class SimpleCalc2Main {

    public static void main(final String... args) {

    }

    private enum Operator {
        PLUS("+", (a, b) -> (double) a + b),

        MINUS("-", (a, b) -> (double) a - b),

        MULTIPLY("*", (a, b) -> (double) a * b),

        DIVIDE("/", (a, b) -> (double) a / b);

        private String op;
        private BiFunction<Integer, Integer, Double> biFunction;

        Operator(String op, BiFunction<Integer, Integer, Double> biFunction) {
            this.op = op;
        }

        public double execute(int a, int b) {
            return biFunction.apply(a, b);
        }
    }
}
