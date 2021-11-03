package codingtest.nadongbin.lec3bdfs;

import java.util.Arrays;

import static java.lang.System.out;

public class C06_음료수_얼려먹기_연습 {

    /*public static int[][] map = {
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };*/

    public static int[][] map = {
            {0, 0, 1, 1, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}
    };

    public static int groupCount = 0;

    public static void main(String[] args) {

        iterateMap();

        out.println("Arrays.deepToString(map) = " + Arrays.deepToString(map));
        out.println("groupCount = " + groupCount);
    }

    private static void iterateMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] != 1) {
                    groupCount++;
                    dfs(i, j);
                }
            }
        }
    }

    private static void dfs(int r, int c) {
        if (r < 0 || r >= map.length || c < 0 || c >= map[0].length) return;

        if (map[r][c] == 1) return;

        map[r][c] = 1;

        MoveType[] moves = MoveType.values();

        for (MoveType d : moves) {
            dfs(r + d.r, c + d.c);
        }
    }

    enum MoveType {
        UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

        int r;
        int c;

        MoveType(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
