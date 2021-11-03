package codingtest.nadongbin.lec3bdfs;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class C02_큐 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        queue.poll();

        queue.offer(5);

        while (!queue.isEmpty()) {
            out.println("queue.poll() = " + queue.poll());
        }
    }
}
