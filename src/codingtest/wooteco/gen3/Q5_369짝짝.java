package codingtest.wooteco.gen3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class Q5_369짝짝 {
    public static void main(String[] args) {
        Solution sol = new Solution();

//        int n = 14;
        int n = 33;

//        int cnt = sol.solution(n);
//        int cnt = sol.solution2(n);
        int cnt = sol.solution3(n);
        out.println("cnt = " + cnt);
    }

    // 동연이 이거 나머지로 품.. while 문 돌려서.. 예외 상황 안생기게끔
    // 10으로 계속 나눈다
    static class Solution {

        // 유부남 아재의.. 문자열 변환풀이
        public int solution3(int n) {

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                String string = String.valueOf(i);
                for (int j = 0; j < string.length(); j++) {
                    char c = string.charAt(j);
                    if (c == '3' || c == '6' || c == '9') cnt++;
                }
            }
            return cnt;
        }

        public int solution2(int number) {

            int cnt = 0;
            for (int i = 1; i <= number; i++) {
                int n = i;
                while (n != 0) {
                    int r = n % 10;
                    if (r == 3 || r == 6 || r == 9) cnt++;
                    n /= 10;
                }
            }

            return cnt;
        }

        public int solution(int number) {
            List<Integer> threeList = new ArrayList<>();
            threeList.add(3);
            threeList.add(6);
            threeList.add(9);
            int cnt = 0;
            for (int i = 1; i <= number; i++) {
                int[] nums = Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < nums.length; j++) {
                    if (threeList.contains(nums[j])) {
                        cnt++;
                    }
                }
            }

            return cnt;
        }
    }
}
