package simple.big;

import static java.lang.System.out;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;

public class BigIntegerDecimal {

    @Test
    void test6() {
        BigDecimal divider = new BigDecimal("1");
        out.println("result = " + new BigDecimal("2.5").divide(divider, 0, RoundingMode.HALF_EVEN));
        out.println("result = " + new BigDecimal("5.5").divide(divider, 0, RoundingMode.HALF_EVEN));
    }

    @Test
    void test5() {
        BigDecimal decimal = new BigDecimal("12.345");
        BigDecimal divider = new BigDecimal("1");

        BigDecimal result = decimal.divide(divider, 2, RoundingMode.UP);
        out.println("result = " + result); //12.35

        // 12.35
        out.println("result = " + new BigDecimal("12.354").divide(divider, 2, RoundingMode.HALF_EVEN));

        // 뒷자리가 짝수 12.36
        out.println("result = " + new BigDecimal("12.356").divide(divider, 2, RoundingMode.HALF_EVEN));

        // 앞자리가 짝수 12.25
        out.println("result = " + new BigDecimal("12.254").divide(divider, 2, RoundingMode.HALF_EVEN));

        out.println("result = " + new BigDecimal("12.255").divide(divider, 2, RoundingMode.HALF_EVEN));

        out.println("result = " + new BigDecimal("12.2553").divide(divider, 2, RoundingMode.HALF_EVEN));

        out.println("result = " + new BigDecimal("12.2556").divide(divider, 2, RoundingMode.HALF_EVEN));

    }

    @Test
    void test4() {
        BigDecimal decimal = new BigDecimal("12.345");
        BigDecimal divider = new BigDecimal("10");
        BigDecimal result = decimal.divide(divider, 2, RoundingMode.DOWN);
        out.println("result = " + result); // 1.23
    }

    @Test
    void test3() {
        BigDecimal bigDecimal = new BigDecimal("10");
        BigDecimal result = new BigDecimal("10");
        BigDecimal minusThing = new BigDecimal("0.1");
        for (int i = 0; i < 100; i++) {
            result = result.subtract(minusThing);
        }
        out.println("result = " + result);
    }

    @Test
    void test2() {
        BigInteger bigInteger = new BigInteger("10");
        BigInteger result = new BigInteger("0");
        BigInteger minusThing = new BigInteger("0.1");
        for (int i = 0; i < 100; i++) {
            result = bigInteger.subtract(minusThing);
        }
        out.println("result = " + result);
    }

    @Test
    void test1_2() {
        float f = 0F;
        for (int i = 0; i < 100; i++) {
            f += 0.1F;
        }
        out.println("f = " + f);
    }

    @Test
    void test1() {
        float f = 10F;
        for (int i = 0; i < 100; i++) {
            f -= 0.1F;
        }
        out.println("f = " + f);
    }
}
