package study.coding.test.backjoon.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Pass
 */
class Sol_2_2121_5 {

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

        Set<Cord> cords = new HashSet<>();
        for (int i = 1; i <= input_number; i++) {
            String[] splits = br.readLine().split(" ");
            int x = Integer.parseInt(splits[0]);
            int y = Integer.parseInt(splits[1]);

            cords.add(new Cord(x, y));
        }

        int squareMatches = 0;
        for (Cord cord : cords) {
            boolean condition1 = cords.contains(new Cord(cord.x + x_size, cord.y));
            boolean condition2 = cords.contains(new Cord(cord.x, cord.y + y_size));
            boolean condition3 = cords.contains(new Cord(cord.x + x_size, cord.y + y_size));

            if (condition1 && condition2 && condition3) {
                squareMatches++;
            }
        }


        return squareMatches + "";
    }

    static class Cord {


        int x;
        int y;

        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
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
    }
}
