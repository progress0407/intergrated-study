package study.coding.test.backjoon.week_5.two_pointer.Boj_2230;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.StringReader;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void t1() {
        assertSolution(
                "3 3\n"
                        + "1\n"
                        + "5\n"
                        + "3",
                "4");
    }

    @Test
    void t2() {
        assertSolution(
                "5 6\n"
                        + "2\n"
                        + "3\n"
                        + "9\n"
                        + "13\n"
                        + "22",
                "6");
    }

    private void assertSolution(final String input, final String output) {
        final Main main = new Main();
        final StringReader reader = new StringReader(input);

        assertThat(main.solve(reader)).isEqualTo(output);
    }
}