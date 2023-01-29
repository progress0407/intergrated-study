package basic.abstractt;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class MySetMain {
    public static void main(final String... args) {
//        MySet<Integer> set = new MySet<>();
//        set.addAll(List.of(1, 2, 3, 4));
//        out.println("set.getAddCount() = " + set.getAddCount());

        Aa aa = new Aa();
        aa.method();
    }

    private interface AInterface {
        default void method() {
            out.println("default method");
        }
    }

    private static class Aa implements AInterface {
        @Override
        public void method() {
            out.println("Aa method");
        }
    }
}
