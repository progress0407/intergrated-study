package sample.staticc;

import org.junit.jupiter.api.Test;
import sample.staticc.Outer.Inner;

public class Main {

    @Test
    void test() {
        Inner inner = new Inner();
        System.out.println("inner = " + inner);
        inner.innerVar = 20;
        System.out.println("inner = " + inner);

        Inner inner2 = new Inner();
        System.out.println("inner2 = " + inner2);
    }
}
