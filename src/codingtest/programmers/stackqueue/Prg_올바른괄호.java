package codingtest.programmers.stackqueue;

import java.util.Stack;

import static java.lang.System.out;

public class Prg_올바른괄호 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        /**
         * "()()"	true
         * "(())()"	true
         * ")()("	false
         * "(()("	false
         */
        String inputStr = "(())()";
        sol.solution(inputStr);
    }

    static class Solution {
        boolean solution(String s) {

            String[] brackets = s.split("");

            Stack<String> stack = new Stack<>();

            for (String bracket : brackets) {
                if (!stack.isEmpty()) {
                    String last = stack.peek();
                    if (last.equals("(") && bracket.equals(")")) {
                        stack.pop(); // 뿌요뿌요 터트리기
                        continue;
                    }
                    stack.push(bracket);
                    continue;
                }
                stack.push(bracket);
            }

            out.println("stack = " + stack);
            if (stack.isEmpty()) {
                return true;
            }

            return false;
        }
    }
}
