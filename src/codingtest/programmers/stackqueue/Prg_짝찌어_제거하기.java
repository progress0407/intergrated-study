package codingtest.programmers.stackqueue;

import java.util.Stack;

import static java.lang.System.out;

public class Prg_짝찌어_제거하기 {
    public static void main(String[] args) {
        String str = "baabaa";
//        String str = "cdcd";
        Solution sol = new Solution();
//        sol.solution(str);
        sol.solution2(str);
    }

    static class Solution {
        public int solution(String s)
        {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                char toPush = s.charAt(i);
                if (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (peek == toPush) {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(toPush);
            }

            out.println("stack = " + stack);

            if (stack.isEmpty()) {
                return 1;
            }
            return 0;
        }

        public int solution2(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty() ? 1 : 0;
        }
    }
}
