package study.coding.test.backjoon.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * 넷이 놀기
 * <p>
 * : 정해진 가로 세로 길이의 사각형 만들기
 */
class Sol_2_2121_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input_number = Integer.parseInt(br.readLine());

        String[] splits_x_y = br.readLine().split(" ");

        int x_size = Integer.parseInt(splits_x_y[0]);
        int y_size = Integer.parseInt(splits_x_y[1]);

        ArrayList<Cord> cords = new ArrayList<>();

        for (int i = 1; i <= input_number; i++) {
            String[] splits = br.readLine().split(" ");
            int cord_x = Integer.parseInt(splits[0]);
            int cord_y = Integer.parseInt(splits[1]);

            cords.add(new Cord(cord_x, cord_y));
        }

        HashSet<Cord> square_conditions = new HashSet<>();
        square_conditions.add(new Cord(x_size, y_size));
        square_conditions.add(new Cord((-1) * x_size, y_size));
        square_conditions.add(new Cord(x_size, (-1) * y_size));
        square_conditions.add(new Cord((-1) * x_size, (-1) * y_size));

        for (int i = 0; i < input_number - 3; i++) {
            for (int j = i + 1; j < input_number - 2; j++) {
                for (int k = j + 1; k < input_number - 1; k++) {
                    for (int l = k + 1; l < input_number; l++) {

                    }
                }
            }
        }
        br.close();
    }

    private static HashSet<Cord> get_refer_cord_square_conditions(HashSet<Cord> square_conditions, Cord refer_cord) {
        HashSet<Cord> refer_cord_square_conditions = new HashSet<>();
        for (Cord square_condition : square_conditions) {
            refer_cord_square_conditions
                    .add(new Cord(refer_cord.x + square_condition.x, refer_cord.y + square_condition.y));
        }
        return refer_cord_square_conditions;
    }

    static class Cord {

        int x;
        int y;

        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
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
