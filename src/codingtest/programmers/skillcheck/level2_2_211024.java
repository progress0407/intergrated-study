package codingtest.programmers.skillcheck;

import java.util.HashSet;

import static java.lang.System.out;

public class level2_2_211024 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int N = 5;
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 3;

        solution.solution(N, road, K);
    }

    static class Solution {

        private final HashSet<Integer> deilveryArea = new HashSet<>();

        public int solution(int N, int[][] road, int K) {
            deilveryArea.add(1);
            for (int i = 0; i < road.length; i++) {
                int next = -1;
                int deliveryTime = road[i][2];

                if (road[i][0] == 1){
                    next = road[i][1];
                    dfs(i, road, K, deliveryTime, next);
                }

                if(road[i][1] == 1) {
                    next = road[i][0];
                    dfs(i, road, K, deliveryTime, next);
                }
            }

            out.println("deilveryArea = " + deilveryArea);

            return deilveryArea.size();
        }

        private void dfs(int index, int[][] road, int K, int sum, int next) {
            deilveryArea.add(next);
            for (int i = 0; i < road.length ; i++) {
                if(road[i][0] == index || road[i][1] == index) continue;
                int deliveryTime = road[i][2];
                sum += deliveryTime;
                if (sum >= K) return;

                if (road[i][0] == next){
                    next = road[i][1];
                    dfs(i, road, K, deliveryTime, next);
                }

                if(road[i][1] == next) {
                    next = road[i][0];
                    dfs(i, road, K, deliveryTime, next);
                }
            }
        }
    }
}
