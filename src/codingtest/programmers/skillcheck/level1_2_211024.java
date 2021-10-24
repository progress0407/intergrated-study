package codingtest.programmers.skillcheck;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class level1_2_211024 {
    public static void main(String[] args) {

        long n = 118372;

        Solution solution = new Solution();
        solution.solution(n);
    }
    static class Solution {
        public long solution(long n) {
            long answer = 0;

            char[] chars = String.valueOf(n).toCharArray();

            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < chars.length; i++) {
                list.add(chars[i] - '0');
            }

            out.println("list = " + list);
            List<Integer> list2 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            out.println("list = " + list);
            out.println("list2 = " + list2);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < list2.size(); i++) {
                sb.append(list2.get(i));
            }

            answer = Long.valueOf(sb.toString());

            out.println("answer = " + answer);

            return answer;
        }
    }
}
