package study.coding.test.backjoon.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 시간 초과
 */
class Sol_2_2121_4 {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        String output = solve(reader);
        System.out.println(output);
    }

    public static String solve(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        int input_number = Integer.parseInt(br.readLine());

        String[] splits_x_y = br.readLine().split(" ");

        int x_size = Integer.parseInt(splits_x_y[0]);
        int y_size = Integer.parseInt(splits_x_y[1]);

        Map<Cord, Boolean> cords = new HashMap<>();
        for (int i = 1; i <= input_number; i++) {
            String[] splits = br.readLine().split(" ");
            int x = Integer.parseInt(splits[0]);
            int y = Integer.parseInt(splits[1]);

            cords.put(new Cord(x, y), true);
        }

        int squareMatches = 0;

        for (Cord cord : cords.keySet()) {

            long matchesCount = cords.keySet()
                    .stream()
                    .parallel()
                    .filter(target ->
                            (cord.x + x_size == target.x && cord.y == target.y) ||
                                    (cord.x + x_size == target.x && cord.y + y_size == target.y) ||
                                    (cord.x + x_size == target.x && cord.y == target.y)
                    )
                    .count();

            if (matchesCount == 3) {
                squareMatches++;
            }
        }

        return squareMatches + "";
    }

    static class Cord implements Comparable<Cord> {


        int x;
        int y;

        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
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
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Cord cord = (Cord) o;
            return x == cord.x && y == cord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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
