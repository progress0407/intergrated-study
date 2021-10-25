package codingtest.programmers.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

public class Prg_땅따먹기_DP {

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };

        sol.solution(land);
    }

    static class Solution {

        private int height;
        private int width;
//        List<Integer> sums = new ArrayList<>();
        Set<Integer> sums = new HashSet<>();

        int solution(int[][] land) {

            height = land.length;
            width = land[0].length;

            for (int i = 0; i < width; i++) {
                dfs(i, 0, land[0][i], land);
            }

            int max = sums.stream().mapToInt(e -> e).max().getAsInt();

            out.println("max = " + max);

            return max;
        }

        private static int cnt = 1;

        private void dfs(int col, int row, int sum, int[][] land) {

            if (row == height - 1) {
                out.println("=====================");
                sums.add(sum);
                return;
            }

            out.printf("# dfs: %d row, col = (%d, %d), sum = %d \n", cnt++, row, col, sum);

            for (int i = 0; i < width; i++) {

                if (i == col) continue; // 행열 같은 경우는 제외

                dfs(i, row + 1, sum + land[row][i], land);
            }
        }
    }
}
