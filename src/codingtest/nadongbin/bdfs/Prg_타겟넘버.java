package codingtest.nadongbin.bdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static codingtest.nadongbin.bdfs.Prg_타겟넘버.ArithmeticOperator.MINUS;
import static codingtest.nadongbin.bdfs.Prg_타겟넘버.ArithmeticOperator.PLUS;
import static java.lang.System.out;

public class Prg_타겟넘버 {
    static class Solution {

        private static int target = 3;
        private static int totalCnt = 0;
        private static int cnt = 0; // 만족하는 경우의 개수
        
        public static void main(String[] args) 
        {
//            int[] numbers = {1, 1, 1, 1, 1};
//            int[] numbers = {2, 2, 2};
            int[] numbers = {1, 1, 1, 1, 1, 1, 1};
//            int[] numbers = {1, 1, 2, 2};

//            solution(numbers, target);
            solution2(numbers, target);

            out.println("cnt = " + cnt);
        }

        public static int solution(int[] numbers, int target) {
            int answer = 0;
            int sum = Arrays.stream(numbers).reduce(Integer::sum).getAsInt();
            out.println("sum = " + sum);
            dfs(numbers, 0, PLUS, 0);
            dfs(numbers, 0, MINUS, 0);

            out.println("cnt = " + cnt);
            
            return answer;
        }



        public static void dfs(int[] numbers, int index, ArithmeticOperator operator, int sum) {

            switch (operator) {
                case PLUS:
                    sum += numbers[index];
                    break;
                case MINUS:
                    sum -= numbers[index];
                    break;
            }

            if (index == numbers.length - 1) {
                if (target == sum) {
                    out.println("sum = " + sum);
                    cnt++;
                }
                return;
            }
            
            dfs(numbers, index + 1, PLUS, sum);
            dfs(numbers, index + 1, MINUS, sum);
        }

        private static void solution2(int[] numbers, int target) {

            int answer = 0;

            dfs2(numbers, new LinkedList<Integer>(), PLUS);
            dfs2(numbers, new LinkedList<Integer>(), MINUS);

        }

        private static void dfs2(int[] numbers, Queue<Integer> queue, ArithmeticOperator operator) {

            int index = queue.size(); // 현재 큐의 사이즈가 index 이다
            int number = numbers[index];

            switch (operator) {
                case PLUS:
                    queue.offer(number);
                    break;
                case MINUS:
                    queue.offer((-1) * number);
                    break;
            }

            int numberSize = numbers.length;

            if (index == numberSize - 1) {
                out.printf("totalCnt = %d, index = %d, numSize = %d, ", ++totalCnt, index, numberSize);
                out.printf("queue = %s \n", queue);

                Integer sum = queue.stream().reduce(Integer::sum).get();

                if (sum == target) {
                    cnt++;
                }

                return;
            }

            dfs2(numbers, new LinkedList<>(queue), PLUS);
            dfs2(numbers, new LinkedList<>(queue), MINUS);

        }
    }

    enum ArithmeticOperator {
        PLUS, MINUS;
    }
    
}
