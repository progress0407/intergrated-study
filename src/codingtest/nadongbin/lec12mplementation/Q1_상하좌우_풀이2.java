package codingtest.nadongbin.lec12mplementation;

import static java.lang.System.out;

public class Q1_상하좌우_풀이2 {

    private static int MAP_SIZE = 5;

    public static void main(String[] args) {
        String inputString = "R R R U D D";

        String[] inputs = inputString.split(" ");

        int x = 1;
        int y = 1;


        int[][] map = new int[MAP_SIZE + 1][MAP_SIZE + 1];

        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            MoveTypes d = MoveTypes.valueOf(input);
            int nx = x + d.x;
            int ny = y + d.y;

            if (nx < 1 || nx > MAP_SIZE || ny < 1 || ny > MAP_SIZE) {
                continue;
            }

            x += d.x;
            y += d.y;
        }

        out.printf("(%d, %d)", x, y);

    }

    enum MoveTypes {

        L(0, -1), R(0, 1), U(-1, 0), D(1, 0);

        int x;
        int y;

        MoveTypes(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
