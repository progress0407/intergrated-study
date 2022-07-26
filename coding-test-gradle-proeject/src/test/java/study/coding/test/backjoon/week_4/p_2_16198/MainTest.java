package study.coding.test.backjoon.week_4.p_2_16198;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.StringReader;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test1() {
        final Main main = new Main();
        final String input =
                "4\n"
                        + "1 2 3 4";
        final StringReader reader = new StringReader(input);

        assertThat(main.solve(reader)).isEqualTo("12");
    }

    @Test
    void test2() {
        final Main main = new Main();
        final String input =
                "5\n"
                        + "100 2 1 3 100";
        final StringReader reader = new StringReader(input);

        assertThat(main.solve(reader)).isEqualTo("10400");
    }

    @Test
    void test3() {
        final Main main = new Main();
        final String input =
                "7\n"
                        + "2 2 7 6 90 5 9";
        final StringReader reader = new StringReader(input);

        assertThat(main.solve(reader)).isEqualTo("1818");
    }

    @Test
    void test4() {
        final Main main = new Main();
        final String input =
                "10\n"
                        + "1 1 1 1 1 1 1 1 1 1";
        final StringReader reader = new StringReader(input);

        assertThat(main.solve(reader)).isEqualTo("8");
    }
}