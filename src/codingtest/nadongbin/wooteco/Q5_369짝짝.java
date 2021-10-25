package codingtest.nadongbin.wooteco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class Q5_369짝짝 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 33;
        int cnt = sol.solution(n);
        out.println("cnt = " + cnt);
    }

    // 동연이 이거 나머지로 품.. while 문 돌려서.. 예외 상황 안생기게끔
    // 10으로 계속 나눈다
    static class Solution {
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
