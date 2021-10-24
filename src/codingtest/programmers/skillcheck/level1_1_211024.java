package codingtest.programmers.skillcheck;

public class level1_1_211024 {
    public static void main(String[] args) {
//        String s = "abcde";
        String s = "qwer";
        Solution solution = new Solution();
        solution.solution(s);
    }
    static class Solution {
        public String solution(String s) {
            int length = s.length();
            int mid = length / 2;
            if (length % 2 == 0) { // 짝수
                return ("" + s.charAt(mid - 1) + s.charAt(mid) + "");
            } else { // 홀수
                return s.charAt(mid) + "";
            }
        }
    }
}
