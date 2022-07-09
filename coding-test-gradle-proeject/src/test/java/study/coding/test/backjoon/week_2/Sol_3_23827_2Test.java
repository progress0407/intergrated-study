package study.coding.test.backjoon.week_2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Sol_3_23827_2Test {

    @Test
    void t_() throws IOException {
        String input =
                "3\n"
                + "1 2 3";
        StringReader reader = new StringReader(input);
        String output = Sol_3_23827_2.solve(reader);

        System.out.println("output = " + output);
    }
}