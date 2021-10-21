package codingtest.nadongbin.bdfs;

import static java.lang.System.out;

public class Prg_네트워크 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        });
    }

    static class Solution {

        public int solution(int n, int[][] computers) {
            // n == computer.length 라고 가정
//            int groupCnt = 간선갯수구하기_잘못품(n, computers);

//            dfs(1, n, computers)

            int v = 2;
            for (int i = 0; i < n; i++) {
                dfs(i, n, computers);
            }


            return 0;
        }

        private void dfs(int i, int n, int[][] computers) {

            if (computers[i][i] == 1) {

            }

        }


        private int 간선갯수구하기_잘못품(int n, int[][] computers) {
            int groupCnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (computers[i][j] == 1) {
                        groupCnt++;
                    }
                }
            }
            return groupCnt;
        }

        private void printMap(int[][] computers) {
            for (int i = 0; i < computers.length; i++) {
                for (int j = 0; j < computers[0].length; j++) {
                    out.printf("%d", computers[i][j]);
                }
                out.println();
            }
        }
    }
}
