package simple.staticc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import simple.staticc.Outer.Inner;

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

    @Test
    void test2() {
        List<Integer> varList = new ArrayList<>();
        varList.add(1);
        varList.add(2);
        varList.add(3);
        varList.add(4);

        List<Integer> concreteList = List.of(1, 2, 3, 4);
        Assertions.assertThat(varList).isEqualTo(concreteList);
        System.out.println("varList = " + varList.equals(concreteList));
    }

    enum Rank {
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4);

        private int value;

        Rank(int value) {
            this.value = value;
        }

    }

    @Test
    void test3() {
        Rank[] ranks = Rank.values();
        System.out.println(Arrays.toString(ranks));
        List<Rank> list = new ArrayList<>(List.of(ranks));
        Collections.reverse(list);
        System.out.println(Arrays.toString(ranks));
    }
}
