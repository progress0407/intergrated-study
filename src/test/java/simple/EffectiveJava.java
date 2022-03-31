package simple;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class EffectiveJava {

    @Test
    void test() {
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            list.add(i);
        }

        out.println(list);

        for (int i = 0; i < 6; i++) {
            out.printf("list.get(%d) = %d \n", i, list.get(i));
        }

        out.println("----------------------------------------------");

        for (int i = 0; i < 3; i++) {
//            StringBuilder   // 1.5
//            StringBuffer // 만든 사람이 후회한
            out.printf("list.get(%d) = %d \n", i, list.get(i));
            list.remove(i); // 주석을 할 때와 안 할 때, 위 행동이 달라진다...
        }

        out.println(list);
    }

}
