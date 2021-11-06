package codingtest.wooteco.gen4;

import java.util.Arrays;

import static java.lang.System.out;

public class Q5_ {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int rows = 3;
        int columns = 4;
//        int rows = 3;
//        int columns = 3;

        sol.solution(rows, columns);
    }

    static class Solution {

        private static int[][] map ;

        private static int num = 1; // 채워나갈 숫자

        public int[][] solution(int rows, int columns) {

            map = new int[rows][columns];

            map[0][0] = num;
            int row = 0;
            int col = 0;

            while (isContinue()) {
                if (num % 2 == 0) { // 짝
                    if (row == rows - 1) row = 0;
                    else row++;
                } else { // 홀
                    if (col == columns - 1) col = 0;
                    else col++;
                }

                if ((rows + columns) % 2 == 0) {
                    if(map[row][col] != 0) break;
                }
                map[row][col] = ++num;
            }

//            out.println("Arrays.deepToString(map) = " + Arrays.deepToString(map));


            return map;
        }

        private boolean isContinue() {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == 0) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
