package codingtest.nadongbin.sortzz;

import java.util.Arrays;

import static java.lang.System.out;

public class Prg_K번째수 {
    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }

    static class Solution {
        public int[] solution(int[] array, int[][] commands) {

            int[] answer = new int[commands.length];

            for (int i = 0; i < commands.length; i++) {
                int[] command = commands[i];
                int start = command[0] - 1;
                int end = command[1];
                int k = command[2] - 1;

                int[] splitArr = Arrays.copyOfRange(array, start, end); // from <= x < to

                Arrays.sort(splitArr);

                for (int anInt : splitArr) {
                    out.print(" " + anInt);
                }
                out.println();

                out.println("splitArr[k] = " + splitArr[k]);

                answer[i] = splitArr[k];
            }


            return answer;
        }
    }

}
