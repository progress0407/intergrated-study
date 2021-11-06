package codingtest.programmers.dbfs;

import static java.lang.System.out;

public class Prg_타겟넘버_복습 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        sol.solution(numbers, target);
    }

    static class Solution {

        private int[] numbers;
        private int count = 0;
        private int target;
        private int callCnt = 0;

        public int solution(int[] numbers, int target) {

            this.numbers = numbers;
            this.target = target;

            for (Op op : Op.values()) {
                dfs(0, 0, op);
            }

            out.println("count = " + count);
            return 1;
        }

        private void dfs(int index, int sum, Op op) {

            callCnt++;
            out.printf("callCnt = %d, index=%d, sum=%d, Op=%s \n", callCnt, index, sum, op);

            sum = getSum(index, sum, op);

            if (index == numbers.length - 1) {
                if (sum == target)
                    count++;
                return;
            }

            dfs(index + 1, sum, Op.PLUS);
            dfs(index + 1, sum, Op.MINUS);
        }

        private int getSum(int index, int sum, Op op) {
            switch (op) {
                case PLUS:
                    sum += numbers[index];
                    break;
                case MINUS:
                    sum -= numbers[index];
                    break;
            }
            return sum;
        }

        enum Op {
            PLUS, MINUS;
        }
    }

}
