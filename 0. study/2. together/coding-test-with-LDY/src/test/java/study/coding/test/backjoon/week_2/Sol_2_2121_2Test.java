package study.coding.test.backjoon.week_2;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.PriorityQueue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.coding.test.backjoon.week_2.Sol_2_2121_2.Cord;

class Sol_2_2121_2Test {

    @DisplayName("test")
    @Test
    void test_() throws IOException {
        String input =
                "6\n"
                        + "2 3\n"
                        + "0 0\n"
                        + "2 0\n"
                        + "2 3\n"
                        + "0 3\n"
                        + "4 0\n"
                        + "4 3";

        StringReader reader = new StringReader(input);
        String output = Sol_2_2121_2.solve(reader);

        out.println("output = " + output);
        assertThat(output).isEqualTo("2");
    }

    @DisplayName("컴페어레이터 구현 1-1")
    @Test
    void comp_1_1() {
        PriorityQueue<P> pq = new PriorityQueue<>();

        pq.offer(new P(2));
        pq.offer(new P(4));
        pq.offer(new P(1));
        pq.offer(new P(3));

        while (!pq.isEmpty()) {
            out.println("pq.poll() = " + pq.poll());
        }
    }

    @DisplayName("컴페어레이터 구현 1-2")
    @Test
    void comp_1_2() {
        PriorityQueue<P> pq = new PriorityQueue<>(
                List.of(
                        new P(2),
                        new P(4),
                        new P(1),
                        new P(3)
                )
        );

        while (!pq.isEmpty()) {
            out.println("pq.poll() = " + pq.poll());
        }
    }

    @DisplayName("컴페어레이터 구현2")
    @Test
    void comp2() {
        PriorityQueue<Cord> pq = new PriorityQueue<>();

        /**
         * 기대하는 정렬 순서
         * (0, 0)
         * (2, 0)
         * (0, 3)
         * (2, 3)
         */

        pq.offer(new Cord(2, 0));
        pq.offer(new Cord(0, 0));
        pq.offer(new Cord(0, 3));
        pq.offer(new Cord(2, 3));

        while (!pq.isEmpty()) {
            out.println("pq.poll() = " + pq.poll());
        }
    }

    static class P implements Comparable<P> {

        int x;

        public P(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(P o) {
            return Integer.compare(x, o.x);
        }

        @Override
        public String toString() {
            return "P{" +
                    "x=" + x +
                    '}';
        }
    }

}