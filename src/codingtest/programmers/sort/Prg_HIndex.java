package codingtest.programmers.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Prg_HIndex {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
//        int[] citations = {7, 3, 5, 8, 1, 0, 4, 11, 9};
//        int[] citations = {15, 13, 11, 10, 11, 8, 7, 4, 1, 0};
//        int[] citations = {1, 1, 5, 7, 6};

        // 9
        // 7 3 5 8 1 0 4 11 9
        // 11 9 8 7 5 4 3 1 0


//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] citations = new int[n];
//        for (int i = 0; i < n; i++) {
//            citations[i] = sc.nextInt();
//        }

        Solution sol = new Solution();
//        sol.solution(citations);
        sol.solution2(citations);

    }

    static class Solution {

        public int solution2(int[] citations) {
            int answer = 0;
            Arrays.sort(citations);
            for(int i=0; i<citations.length; i++){
                int smaller = Math.min(citations[i], citations.length-i);
                answer = Math.max(answer, smaller);
            }
            return answer;
        }

        public int solution(int[] citations) {
            int answer = 0;

            Integer[] nums = IntStream.of(citations).boxed().toArray(Integer[]::new);

            Arrays.sort(nums, Collections.reverseOrder()); // 6 5 3 1 0

            out.println("Arrays.toString() = " + Arrays.toString(nums));

            int max = nums[0];
            // 조건이 성립할 때 까지
            while (hIndex(nums, max) != 1) {
                max--;
            }

            out.println("max = " + max);

            return max;
        }

        private int hIndex(Integer[] citations, int h) {
            int cnt = (int) Arrays.stream(citations).filter(e -> e >= h).count();
            if (cnt >= h) return 1;
            else return -1;
        }
    }
}
