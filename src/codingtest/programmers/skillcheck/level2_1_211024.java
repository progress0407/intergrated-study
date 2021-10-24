package codingtest.programmers.skillcheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class level2_1_211024 {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        Solution solution = new Solution();
        solution.solution(scoville, k);
    }

    static class Solution {
        public int solution(int[] scoville, int K) {
            ArrayList<Integer> scovileList = new ArrayList<>();

            for (int i = 0; i < scoville.length; i++) {
                scovileList.add(scoville[i]);
            }

            // scovileList = scovileList.stream().sorted().collect(Collectors.toList());
            int cnt = 0;
            while (!checkK(scovileList, K)) {
                Collections.sort(scovileList);
                int newScovile = getNewScovile(scovileList);
                if (newScovile == -1) return -1; // 스코빌 만들지 못함
                scovileList.add(newScovile);
                cnt++;
            }

            return cnt;
        }

        private int getNewScovile(ArrayList<Integer> scovileList) {
            if(scovileList.isEmpty()) return -1;
            Integer a = scovileList.remove(0);
            if(scovileList.isEmpty()) return -1;
            Integer b = scovileList.remove(0);
            return a + b * 2;
        }

        // 스코빌 만족 여부
        private boolean checkK(ArrayList<Integer> scovilleList, int K) {
            for (int i = 0; i < scovilleList.size(); i++) {
                if (scovilleList.get(i) < K) {
                    return false;
                }
            }
            return true;
        }
    }
}
