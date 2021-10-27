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
//        sol.solution(inputStr); // 정확성 pass, 효율성 fail
        sol.solution2(inputStr);
    }

    static class Solution {

        boolean solution2(String s) {

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {

                char bracket = s.charAt(i);

                if (!stack.isEmpty()) {
                    char last = stack.peek();
                    if (last == '(' && bracket == ')') {
                        stack.pop();
                        continue;
                    }
                    stack.push(bracket);
                    continue;
                }
                stack.push(bracket);
            }

            if(stack.isEmpty()) return true;
            return false;
        }

        boolean solution(String s) {

            String[] brackets = s.split("");

            Stack<String> stack = new Stack<>();

            for (String bracket : brackets) {

                if (stack.size() > brackets.length) {
                    return false;
                }

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
