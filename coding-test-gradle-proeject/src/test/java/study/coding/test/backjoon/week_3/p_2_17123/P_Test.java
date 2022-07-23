package study.coding.test.backjoon.week_3.p_2_17123;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class P_Test {

    P p = new P();

    @Test
    void t1() {
        final String input =
                "3\n"
                + "3 3\n"
                + "1 2 3\n"
                + "4 5 6\n"
                + "7 8 9\n"
                + "1 1 2 3 3\n"
                + "2 2 3 2 -5\n"
                + "1 1 3 2 1\n"
                + "2 1\n"
                + "10 20\n"
                + "30 40\n"
                + "1 1 2 2 -30\n"
                + "1 3\n"
                + "1000\n"
                + "1 1 1 1 1000\n"
                + "1 1 1 1 -1000\n"
                + "1 1 1 1 1000";

        final String actual = p.solve(input);

        final String expected =
                "17 21 21\n"
                + "21 14 24\n"
                + "-30 10\n"
                + "-20 0\n"
                + "2000\n"
                + "2000";

        assertThat(actual).isEqualTo(expected);
    }

}