package study.coding.test.backjoon.week_2.sol_4_12789;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.StringReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

abstract class Sol_4_12789Test {
    
    protected Sol_4_12789 sol;

    public Sol_4_12789Test(Sol_4_12789 sol) {
        this.sol = sol;
    }

    @Test
    void test() {
        String input = "5\n"
                + "5 4 1 3 2";

        StringReader reader = new StringReader(input);
        String output = sol.solve(reader);

        out.println("output = " + output);

        assertThat(output).isEqualTo("Nice");
    }

    @Test
    void test2() {
        String input = "4\n"
                + "3 5 4 2";

        StringReader reader = new StringReader(input);
        String output = sol.solve(reader);

        out.println("output = " + output);

        assertThat(output).isEqualTo("Sad");
    }

    @Test
    void test3() {
        String input = "4\n"
                + "2 3 4 1";

        StringReader reader = new StringReader(input);
        String output = sol.solve(reader);

        out.println("output = " + output);

        assertThat(output).isEqualTo("Sad");
    }

    @Test
    void test4() {
        String input = "5\n"
                + "4 5 2 1 3";

        StringReader reader = new StringReader(input);
        String output = sol.solve(reader);

        out.println("output = " + output);

        assertThat(output).isEqualTo("Sad");
    }

    @Test
    void test5() {
        String input = "5\n"
                + "5 1 2 4 3";

        StringReader reader = new StringReader(input);
        String output = sol.solve(reader);

        out.println("output = " + output);

        assertThat(output).isEqualTo("Nice");
    }

    @Test
    void test6() {
        String input = "5\n"
                + "5 4 3 1 2";

        StringReader reader = new StringReader(input);
        String output = sol.solve(reader);

        out.println("output = " + output);

        assertThat(output).isEqualTo("Nice");
    }

    @Test
    void test7() {
        String input = "5\n"
                + "10005 10004 10003 10001 10002";

        StringReader reader = new StringReader(input);
        String output = sol.solve(reader);

        out.println("output = " + output);

        assertThat(output).isEqualTo("Nice");
    }

    @Test
    void test8() {
        String input = "4\n"
                + "3 2 1 5";

        StringReader reader = new StringReader(input);
        String output = sol.solve(reader);

        out.println("output = " + output);

        assertThat(output).isEqualTo("Nice");
    }
}
