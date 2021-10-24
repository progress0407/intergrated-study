package codingtest.nadongbin.sortzz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class Prg_가장큰수 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /**
         * 3
         * 6 10 2
         * -> 6 2 10
         *
         * 5
         * 3 30 34 5 9
         * -> 9 5 34 3 30
         *
         * 2
         * 10 101
         *
         * 2
         * 402212 12
         *
         * 2
         * 40 404 -> 40440
         *
         * 2
         * 0 0
         *
         * 4
         * 21 212 30 303
         * => 3033021221
         *
         */
        out.print("n 입력: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        out.print("배열 입력: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        sol.solution(numbers);

    }

    static class Solution {
        public String solution(int[] numbers) {

//            Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
            Integer[] nums = IntStream.of(numbers).boxed().toArray(Integer[]::new);

            out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
            Arrays.sort(nums, CustomComparator());
            out.println("Arrays.toString(nums) = " + Arrays.toString(nums));

            // 0 + 0 인경우 00 이 아닌 0이 되어야 한다
//            String answer = Arrays.stream(nums).map(String::valueOf).reduce((a, b) -> a + b).orElseGet(()->"");

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < nums.length; i++) {
                sb.append(nums[i]);
            }


            // int 범위는 21억인데.. 이것을 넘으므로
            while (sb.length() > 0) {
                // 맨앞이 0이 아니거나 0 하나만 남은 등의 경우 제외
                if (sb.charAt(0) != '0' || sb.length() == 1) break;
                sb.deleteCharAt(0);
            }

            out.println("answer = " + sb);
            return sb.toString();
        }

        private Comparator<Integer> CustomComparator() {
            return (o1, o2) -> {

                String s1 = o1.toString();
                String s2 = o2.toString();

                Integer u1 = Integer.valueOf(s1 + s2);// 3 30
                Integer u2 = Integer.valueOf(s2 + s1);// 30 3

                return u2.compareTo(u1);
            };
        }
    }

}
