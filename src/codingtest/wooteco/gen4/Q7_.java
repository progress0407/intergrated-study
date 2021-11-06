package codingtest.wooteco.gen4;

import java.util.Arrays;

import static java.lang.System.out;

public class Q7_ {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] grid = {"1", "234", "56789"};
        boolean clockwise = true;
        sol.solution(grid, clockwise);
    }

    static class Solution {

        private static Character[][] originalMap;
        private static Character[][] transferedMap;
        private static int R_SIZE;
        private static int C_SIZE;

        public String[] solution(String[] gridInput, boolean clockwise) {

            initData(gridInput);

            initData2(gridInput); // data Set

            out.println("Arrays.deepToString(originalMap) = " + Arrays.deepToString(originalMap));

            if (clockwise) {
                for (int i = 0; i < R_SIZE; i++) {
                    for (int j = 0; j < C_SIZE; j++) {
                        // 새로운 90도 회전된 행열을 만든다
                        int nr = j; // 그대로
                        int nc = R_SIZE - 1 - i;
                        transferedMap[nr][nc] = originalMap[i][j];
                    }
                }
            }

            for (Character[] characters : transferedMap) {
                out.println("Arrays.deepToString(characters) = " + Arrays.deepToString(characters));
            }
            String[] answer = new String[transferedMap.length];


            return answer;
        }

        private void initData2(String[] gridInput) {
            for (int i = 0; i < gridInput.length; i++) {
                for (int j = 0; j < gridInput[i].length(); j++) {
                    originalMap[i][j] = gridInput[i].charAt(j);
                }
            }
        }

        private void initData(String[] gridInput) {
            int max = 0;
            for (String gridOne : gridInput) {
                if (max < gridOne.length()) {
                    max = gridOne.length();
                }
            }
            originalMap = new Character[gridInput.length][max];
            transferedMap = new Character[max][gridInput.length];

            R_SIZE = gridInput.length;
            C_SIZE = max;
        }
    }
}
