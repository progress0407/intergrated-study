package study.coding.test.backjoon.week_4.p_1_21938;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.StringReader;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test1() {
        final Main main = new Main();
        final String input =
                "3 3\n"
                        + "255 255 255 100 100 100 255 255 255\n"
                        + "100 100 100 255 255 255 100 100 100\n"
                        + "255 255 255 100 100 100 255 255 255\n"
                        + "101";
        assertThat(main.solve(new StringReader(input))).isEqualTo("5");
    }

    @Test
    void test2() {
        final Main main = new Main();
        final String input =
                "2 2\n"
                        + "124 150 123 100 100 100\n"
                        + "103 103 103 183 5 3\n"
                        + "255";
        assertThat(main.solve(new StringReader(input))).isEqualTo("0");
    }

    @Test
    void test3() {
        final Main main = new Main();
        final String input =
                "2 3\n"
                        + "100 100 100 100 100 100 100 100 100\n"
                        + "100 100 100 255 255 255 100 100 100\n"
                        + "101";
        assertThat(main.solve(new StringReader(input))).isEqualTo("1");
    }

    @Test
    void test4() {
        final Main main = new Main();
        final String input =
                "3 3\n"
                        + "256 256 256 256 256 256 256 256 256\n"
                        + "256 256 256 0 0 0 256 256 256\n"
                        + "0 0 0 256 256 256 256 256 256\n"
                        + "100";
        assertThat(main.solve(new StringReader(input))).isEqualTo("1");
    }
}
