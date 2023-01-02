package study.coding.test.backjoon.week_5.p_20922;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void t1() {
        assertSolution(
                "9 2\n"
                        + "3 2 5 5 6 4 4 5 7",
                "7");
    }

    @Test
    void t2() {
        assertSolution(
                "10 1\n"
                        + "1 2 3 4 5 6 6 7 8 9",
                "6");
    }

    @Test
    void t3() {
        assertSolution(
                "6 1\n"
                        + "1 3 3 5 6 7",
                "4");
    }

    private void assertSolution(final String input, final String output) {
        final Main main = new Main();
        final StringReader reader = new StringReader(input);

        assertThat(main.solve(reader)).isEqualTo(output);
    }

}