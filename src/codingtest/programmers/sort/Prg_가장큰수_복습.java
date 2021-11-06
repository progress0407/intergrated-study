package codingtest.programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.out;

public class Prg_가장큰수_복습 {
    public static void main(String[] args) {

        Solution sol = new Solution();
//        int[] numbers = {6, 10, 2};
//        int[] numbers = {3, 30, 34, 5, 9};
        int[] numbers = {0, 0, 0};
        sol.solution(numbers);
    }

    static class Solution {
        public String solution(int[] numbers) {
            Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
            out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
            Arrays.sort(nums, new CustomComparator());
            out.println("Arrays.toString(nums) = " + Arrays.toString(nums));

            String result = Arrays.stream(nums).map(String::valueOf).reduce((a, b) -> a + b).get();
            StringBuilder sb = new StringBuilder(result);

            out.println("result = " + result);

            while (sb.length() > 1) {
                if(sb.charAt(0) != '0') break;
                sb.deleteCharAt(0);
            }

            out.println("sb = " + sb);

            return "nums";
        }

        static class CustomComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return (s2 + s1).compareTo(s1 + s2);
            }
        }

    }
}
