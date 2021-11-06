package codingtest.wooteco.gen4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class Q4_BFS로다시 {

    public static void main(String[] args) {

        Solution sol = new Solution();

        String s = "aaabbaaa";
        sol.solution(s);

    }

    static class Solution {
        private static int[] visited;
        private static char[] rings;
        private static int groupCnt = 1;

        /**
         * 깊이가 아닌 너비우선 탐색으로 가야한다!!!
         */
        public int[] solution(String s) {

            initData(s);

            Queue<Target> q = new LinkedList<>();

            q.offer(new Target(0, rings[0]));
            visited[0] = groupCnt;

            while (!q.isEmpty()) {
                Target target = q.poll();

                int prevIndex = target.index - 1;
                if (prevIndex == -1) {
                    prevIndex = rings.length - 1;
                }

                if (visited[prevIndex] == 0) {
                    if (rings[prevIndex] != rings[target.index]) {
                        groupCnt++;
                    }
                    q.offer(new Target(prevIndex, rings[prevIndex]));
                }


                int nextIndex = target.index + 1;
                if (nextIndex == rings.length) {
                    nextIndex = 0;
                }

                if (visited[nextIndex] == 0) {
                    if (rings[nextIndex] != rings[target.index]) {
                        groupCnt++;
                    }
                    q.offer(new Target(nextIndex, rings[nextIndex]));
                }
            }

            out.println("visited = " + visited);

            int[] answer = {};
            return answer;
        }

        private static class Target {
            int index;
            char val;

            public Target(int index, char val) {
                this.index = index;
                this.val = val;
            }
        }

        private void initData(String s) {
            visited = new int[s.length()];

            char[] chars = s.toCharArray();
            rings = new char[s.length()];
            for (int i = 0; i < chars.length; i++) {
                rings[i] = chars[i];
            }
        }
    }
}
