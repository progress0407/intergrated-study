package test.grammer.collectionzz;

import java.util.*;

import static java.lang.System.out;

public class SetMain {
    public static void main(String[] args) {
        test1();
//        test2();
    }

    private static void test2() {

    }

    private static void test1() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        for (int i : set) {
            out.println("i = " + i);
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        set = new HashSet<>(list);

        out.println("===== set");
        set.forEach(out::println);

        out.println("set.contains(3) = " + set.contains(3));
        out.println("set.contains(4) = " + set.contains(4));
    }
}
