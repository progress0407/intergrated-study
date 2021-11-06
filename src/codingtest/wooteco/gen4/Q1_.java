package codingtest.wooteco.gen4;

import java.util.Arrays;

import static java.lang.System.out;

public class Q1_ {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        int[] arr = {2, 1, 3, 1, 2, 1};
//        int[] arr = {3, 3, 3, 3, 3, 3};
        int[] arr = {1, 2, 3};

        int[] solution = sol.solution(arr);
    }

    static class Solution {
        public int[] solution(int[] arr) {

            Arrays.sort(arr);

            int[] count = getCountArr(arr);  // 갯수를 담는 배열

            int max = getMax(count);

            out.println("Arrays.toString(count) = " + Arrays.toString(count));

            int[] answer = new int[3];

            for (int i = 1; i <= 3; i++) {
                answer[i - 1] = max - count[i];
            }

            out.println("Arrays.sort(answer) = " + Arrays.toString(answer));

            return answer;
        }

        private int getMax(int[] count) {
            int max = -1;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > max) {
                    max = count[i];
                }
            }
            return max;
        }

        private int[] getCountArr(int[] arr) {
            int[] count = new int[3 + 1];
            for (int i = 1; i <= 3; i++) {

                for (int x : arr) {
                    if (x == i) {
                        count[i]++;
                    }
                }
            }
            return count;
        }
    }
}
