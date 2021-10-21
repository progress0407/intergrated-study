package codingtest.nadongbin.implementation;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Prg_땅따먹기 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] land = {
                {1,2,3,5},
                {5,6,7,8},
                {4,3,2,1}
        };

        sol.solution(land);
    }

    static class Solution {

        private int height;
        private int width;

        int solution(int[][] land) {
            int answer = 0;

            List<Integer> sums = new ArrayList<>();

            height = land.length;
            width = land[0].length;

            for (int i = 0; i < width; i++) {
                dfs(i, 0, land[0][i], land);
            }

            return answer;
        }

        private static int cnt = 1;

        private void dfs(int col, int row, int sum, int[][] land) {

            out.printf("# dfs: %d row, col = (%d, %d), sum = %d \n", cnt++, row, col, sum);

            if (row == height - 1) {
                out.println("=====================");
                return;
            }

            for (int i = 0; i < width; i++) {

                if (i == col) continue; // 행열 같은 경우는 제외

                dfs(i, row + 1, sum + land[row][i], land);
            }

        }
    }
}
