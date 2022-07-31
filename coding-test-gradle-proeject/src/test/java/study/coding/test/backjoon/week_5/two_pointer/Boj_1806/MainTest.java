package study.coding.test.backjoon.week_5.two_pointer.Boj_1806;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.StringReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void t1() {
        assertSolution(
                "10 15\n"
                        + "5 1 3 5 10 7 4 9 2 8",
                "2");
    }

    private void assertSolution(final String input, final String output) {
        final Main main = new Main();
        final StringReader reader = new StringReader(input);

        assertThat(main.solve(reader)).isEqualTo(output);
    }
}