package codingtest.programmers.bruteforce;

import java.util.Arrays;
import java.util.HashSet;

import static java.lang.System.out;

public class Prg_소수찾기 {
    public static void main(String[] args) {

        Solution sol = new Solution();

//        String numbers = "17";
        String numbers = "011";


        sol.solution(numbers);
    }

    static class Solution {

        private static HashSet<Integer> set = new HashSet<>();

        public int solution(String nums) {

            String[] numbers = nums.split("");

            boolean[] visited = new boolean[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                dfs(numbers, i, visited, numbers[i]);
            }

            return set.size();
        }

        private void dfs(String[] numbers, int index, boolean[] visited, String newStr) {
            visited[index] = true;

            out.println("newStr = " + newStr);
            set.add(Integer.parseInt(newStr));
            out.println("set = " + set);
            out.println("Arrays.toString(visited) = " + Arrays.toString(visited));

            for (int i = 0; i < numbers.length; i++) {
                if (!visited[i]) {
                    dfs(numbers, i, visited, newStr + numbers[i]);
                }
            }
        }
    }
}
