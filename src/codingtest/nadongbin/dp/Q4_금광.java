package codingtest.nadongbin.dp;

import java.util.Arrays;

import static java.lang.System.out;

public class Q4_금광 {
    public static void main(String[] args) {
        int[][] map = {
                {1, 3, 2, 2},
                {2, 1, 4, 1},
                {0, 6, 4, 7}
        };

        solve(map);
    }

    private static void solve(int[][] map) {
        out.println("Arrays.toString(map) = " + Arrays.toString(map));
        out.println("Arrays.deepToString(map) = " + Arrays.deepToString(map));

        int[] d = new int[map[0].length + 1];
        d[0] = getMax(map);

    }

    private static int getMax(int[][] map) {
        int max = map[0][0];
        for (int i = 0; i < map.length; i++) {
            if (max < map[i][0]) {
                max = map[i][0];
            }
        }
        return max;
    }
}
