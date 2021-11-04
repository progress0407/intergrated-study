package codingtest.programmers.hash;

import java.util.HashMap;

import static java.lang.System.out;


public class Prg_전화번호_목록 {

    public static void main(String[] args) {
        Solution sol = new Solution();

//        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"123","456","789"};
        String[] phone_book = {"12","123","1235","567","88"};
        boolean result = sol.solution(phone_book);
        out.println("result = " + result);
    }

    static class Solution {
        
        // 마지막 효율성 2개를 통과하지 못한다
        public boolean solution(String[] phoneBooks) {

            for (int i = 0; i < phoneBooks.length - 1; i++) {
                for (int j = i + 1; j < phoneBooks.length; j++) {
                    if (phoneBooks[i].startsWith(phoneBooks[j]) || phoneBooks[j].startsWith(phoneBooks[i])) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
