package simple;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

public class SetTest {

    @Test
    void test2() {
//        EnumSet<MyFruit> set = EnumSet.of(MyFruit.APPLE, MyFruit.BANANA, MyFruit.PEACH);
//        System.out.println("set = " + set);
        EnumSet<MyFruit> myFruits = EnumSet.noneOf(MyFruit.class);
        System.out.println("myFruits = " + myFruits);
    }

    @RequiredArgsConstructor
    private enum MyFruit {
        APPLE(1), BANANA(2), PEACH(3);
        private final int code;
    }

    @Test
    void test() {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        String find = set.stream().filter(s -> s.equals("f")).findAny().orElseGet(() -> "empty");
        System.out.println("find = " + find);
    }
}
