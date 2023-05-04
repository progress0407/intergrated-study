package basic.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class ArrayDequeMain {

    @Test
    void test() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Collections.shuffle(list);
        Queue<Integer> q = new ArrayDeque<>(list);
        System.out.println("q = " + q);
    }

    @Test
    void test2() {
        Queue<Integer> q = new ArrayDeque<>(List.of(1, 2, 3, 4, 5));
        Collections.shuffle(new ArrayList<>(q));
        System.out.println("q = " + q);
    }
}
