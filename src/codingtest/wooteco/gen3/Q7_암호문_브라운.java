package codingtest.wooteco.gen3;

import java.util.LinkedList;
import java.util.Stack;

import static java.lang.System.out;

public class Q7_암호문_브라운 {
    public static void main(String[] args) {
        String str = "browoanoommnaon";
//        String str = "zyelleyz";
        Solution sol = new Solution();
//        sol.solution(str);
        sol.solution3(str);
    }

    /**
     * stack 에서 삽입될때 뿌요뿌요 터트리기
     */

    static class Solution {

        public String solution3(String cryptogram) {

            Stack<Character> q = new Stack<>();

            for (int i = 0; i < cryptogram.length(); i++) {
                char alpha = cryptogram.charAt(i);
                if (q.isEmpty()) {
                    q.push(alpha);
                } else if(q.peek() == alpha) q.pop();
                else q.push(alpha);
            }

            out.println("q = " + q);

            return null;
        }

        public String solution2(String cryptogram) {
            String[] cryptoArr = cryptogram.split("");
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < cryptoArr.length; i++) {
                String element = cryptoArr[i];

                if (!stack.isEmpty()) {
                    String last = stack.peek();
                    if (last.equals(element)) {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(element);
            }

            out.println("stack.toString() = " + stack.toString());

            return stack.toString();
        }

        public String solution(String cryptogram) {
            // browoanoommnaon
            String[] cryptos = cryptogram.split("");
            LinkedList<String> queue = new LinkedList<>();
            for (int i = 0; i < cryptos.length; i++) {
                queue.offer(cryptos[i]);
            }

            while (hasDuple(queue)) {
                for (int i = 0; i < queue.size() - 1; i++) {
                    if (queue.get(i).equals(queue.get(i + 1))) {
                        int cnt = 0;
                        String dupleStr = queue.get(i);
                        // queue 사이즈를 고려 안하면 예외 터진다
                        while (i + cnt < queue.size() && dupleStr.equals(queue.get(i + cnt))) cnt++;
                        while (cnt-- > 0) queue.remove(i);
                    }
                }
            }

            String result = queue.toString();
            out.println("result = " + result);

            return result;
        }

        private boolean hasDuple(LinkedList<String> queue) { // 중복 여부
            for (int i = 0; i < queue.size() - 1; i++) {
                if (queue.get(i).equals(queue.get(i + 1))) {
                    return true;
                }
            }
            return false;
        }
    }
}
