package basic.abstractt;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class Main {

    @Test
    void name() {
        List<Number> numbers = new ArrayList<>();
        numbers.add(1); // Integer
        numbers.add(20L); // Long
        numbers.add(3.2); // Double
        numbers.add(5.4F); // Float

        for (Number number : numbers) {
            out.println(number.byteValue());
        }
    }

    @Test
    void test() {

    }
}
