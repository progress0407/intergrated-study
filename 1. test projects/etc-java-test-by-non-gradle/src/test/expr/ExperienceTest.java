package test.expr;

import static java.lang.System.out;

public class ExperienceTest {

    public static void main(String[] args) {
        String str = "a";
        internalMethod(str);
        out.println("str = " + str);
    }

    private static void internalMethod(String str) {
        str = "b";
    }
}
