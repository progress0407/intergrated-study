package study.coding.test.backjoon.week_3.p_1_11568;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.Reader;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test_1() {
        final String baeckjoonInput =
                "5\n"
                        + "8 9 1 2 10";
        final P p = new P();
        final String output = p.solve(new StringReader(baeckjoonInput));
        assertThat(output).isEqualTo("3");
    }

    @Test
    void test_2() {
        final String baeckjoonInput =
                "8\n"
                        + "5 4 3 2 1 6 7 8";
        final P p = new P();
        final String output = p.solve(new StringReader(baeckjoonInput));
        assertThat(output).isEqualTo("4");
    }
}