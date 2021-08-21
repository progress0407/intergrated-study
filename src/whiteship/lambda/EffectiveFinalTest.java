package whiteship.lambda;

import java.util.function.IntConsumer;

import static java.lang.System.out;

public class EffectiveFinalTest {
    int baseNum = 10;

    public static void main(String[] args) {
        EffectiveFinalTest effectiveFinalTest = new EffectiveFinalTest();
        effectiveFinalTest.run();
    }

    private void run() {

        IntConsumer printInt = (i) -> {
            out.println(i + baseNum);
        };

        printInt.accept(3);
        baseNum++;
        printInt.accept(3);

    }
}
