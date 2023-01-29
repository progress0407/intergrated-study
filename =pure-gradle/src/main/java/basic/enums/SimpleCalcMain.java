package basic.enums;

import static java.lang.System.out;

import java.util.function.BiFunction;

public class SimpleCalcMain {

    public static void main(final String... args) {
        out.println("PLUS = " + Operator.PLUS.arithmetic(3, 7));
        out.println("MINUS = " + Operator.MINUS.arithmetic(3, 7));
        out.println("MULTIPLY = " + Operator.MULTIPLY.arithmetic(3, 7));
        out.println("DIVIDE = " + Operator.DIVIDE.arithmetic(3, 7));
    }

    private enum Operator {
        PLUS {
            @Override
            double arithmetic(int a, int b) {
                return a + b;
            }
        }, MINUS {
            @Override
            double arithmetic(int a, int b) {
                return a - b;
            }
        }, MULTIPLY {
            @Override
            double arithmetic(int a, int b) {
                return a * b;
            }
        }, DIVIDE {
            @Override
            double arithmetic(int a, int b) {
                return a / b;
            }
        };

        abstract double arithmetic(int a, int b);
    }
}
