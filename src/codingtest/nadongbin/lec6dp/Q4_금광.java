package codingtest.nadongbin.lec6dp;

import java.util.Arrays;

import static java.lang.System.out;

public class Q4_금광 {
    public static void main(String[] args) {
        int[][] map = {
                {1, 3, 2, 2},
                {2, 1, 4, 1},
                {0, 6, 4, 7}
        };

//        solve(map);
        solve2(map);
    }

    private static void solve2(int[][] map) {

        int n = map.length;
        int m = map[0].length;

        int[][] d = new int[n][m];

        d[0][0] = map[0][0];
        d[1][0] = map[1][0];
        d[2][0] = map[2][0];

        int left = 0;
        int leftUp = 0;
        int leftDown = 0;

        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {

                if (i == 0) leftUp = 0;
                else leftUp = d[i - 1][j - 1];

                if (i == 2) leftDown = 0;
                else leftDown = d[i + 1][j - 1];

                left = d[i][j - 1];

                d[i][j] = map[i][j] + Math.max(leftUp, Math.max(left, leftDown));
            }
        }

        out.println("Arrays.deepToString(d) = " + Arrays.deepToString(d));
    }

    private static void solve(int[][] map) {

        int[][] d = new int[map.length][map[0].length];

        d[0][0] = map[0][0];
        d[1][0] = map[1][0];
        d[2][0] = map[2][0];

        int lastPos = map[0].length - 1;
        for (int i = 1; i <= lastPos; i++) {
            d[0][i] = map[0][i] + Math.max(d[0][i - 1], d[1][i - 1]);
            d[1][i] = map[1][i] + getMaxOf3term(d[0][i - 1], d[1][i - 1], d[2][i - 1]);
            d[2][i] = map[2][i] + Math.max(d[1][i - 1], d[2][i - 1]);
        }

        int max = getMaxOf3term(map[0][lastPos], map[1][lastPos], map[2][lastPos]);

        out.println("max = " + max);
    }

    private static int getMaxOf3term(int a, int b, int c) {
        return a > b ? (Math.max(a, c)) : (Math.max(b, c));
    }
}
