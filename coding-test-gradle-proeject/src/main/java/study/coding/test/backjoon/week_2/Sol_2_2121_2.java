package study.coding.test.backjoon.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Sol_2_2121_2 {

    /**
     * 넷이 놀기
     */

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        String output = solve(reader);
    }

    public static String solve(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        int input_number = Integer.parseInt(br.readLine());

        String[] splits_x_y = br.readLine().split(" ");

        int x_size = Integer.parseInt(splits_x_y[0]);
        int y_size = Integer.parseInt(splits_x_y[1]);

        List<Cord> cords = new ArrayList<>();
        for (int i = 1; i <= input_number; i++) {
            String[] splits = br.readLine().split(" ");
            int cord_x = Integer.parseInt(splits[0]);
            int cord_y = Integer.parseInt(splits[1]);

            cords.add(new Cord(cord_x, cord_y));
        }

        Conditions conditions = new Conditions(x_size, y_size);

        int squareMatches = 0;

        for (int i = 0; i < input_number - 3; i++) {
            for (int j = i + 1; j < input_number - 2; j++) {
                for (int k = j + 1; k < input_number - 1; k++) {
                    for (int l = k + 1; l < input_number; l++) {
                        boolean allCordMatch = conditions.isMatch(
                                cords.get(j), cords.get(k), cords.get(l), cords.get(i)
                        );

                        if (allCordMatch) {
                            squareMatches++;
                        }
                    }
                }
            }
        }

        return String.valueOf(squareMatches);
    }

    static class Conditions {

        private final int x_size;
        private final int y_size;
        private final Cord[] condition_matches = new Cord[3];

        public Conditions(int x_size, int y_size) {
            this.x_size = x_size;
            this.y_size = y_size;

            condition_matches[0] = new Cord(x_size, 0);
            condition_matches[1] = new Cord(0, y_size);
            condition_matches[2] = new Cord(x_size, y_size);
        }

        public boolean isMatch(Cord cord1_un_sorted,
                               Cord cord2_un_sorted,
                               Cord cord3_un_sorted,
                               Cord cord4_un_sorted) {

            PriorityQueue<Cord> pq = new PriorityQueue<>();
            pq.offer(cord1_un_sorted);
            pq.offer(cord2_un_sorted);
            pq.offer(cord3_un_sorted);
            pq.offer(cord4_un_sorted);

            Cord cord1_sorted = pq.poll();
            Cord cord2_sorted = pq.poll();
            Cord cord3_sorted = pq.poll();
            Cord cord4_sorted = pq.poll();

            boolean condition_1 = condition_matches[0].matches(cord1_sorted, cord2_sorted);
            boolean condition_2 =condition_matches[1].matches(cord1_sorted, cord3_sorted);
            boolean condition_3 =condition_matches[2].matches(cord1_sorted, cord4_sorted);

            return condition_1 && condition_2 && condition_3;
        }

        @Override
        public String toString() {
            return "Conditions{" +
                    "x_size=" + x_size +
                    ", y_size=" + y_size +
                    ", condition_matches=" + Arrays.toString(condition_matches) +
                    '}';
        }
    }

    static class Cord implements Comparable<Cord> {


        int x;
        int y;

        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean matches(Cord cord1, Cord cord2) {
            return cord1.x + x == cord2.x && cord1.y + y == cord2.y;
        }

        @Override
        public int compareTo(Cord o) {
            /**
             * 기대하는 정렬 순서
             * (0, 0)
             * (2, 0)
             * (0, 3)
             * (2, 3)
             */
            return Integer.compare(
                    Integer.compare(x, o.x),
                    Integer.compare(o.y, y)
            );
        }

        @Override
        public String toString() {
            return "Cord{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
