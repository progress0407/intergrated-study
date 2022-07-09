package study.coding.test.backjoon.week_1;

import static java.lang.System.out;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

class Sol_3_4796Test {

    @DisplayName("")
    @Test
    void qwe_() throws IOException {
        String input =
                "5 8 20\n"
                        + "5 8 17\n"
                        + "0 0 0";
        Reader reader = new StringReader(input);
        ArrayList<String> solve = Sol_3_4796.solve(reader);
        out.println("solve = " + solve);
    }

}