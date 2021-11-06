package codingtest.wooteco.gen4;

import java.util.Arrays;

import static java.lang.System.out;

public class Q4_ {

    public static void main(String[] args) {

        Solution sol = new Solution();

//        String s = "aaabbaaa";
        String s = "wowwow";
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

            for (int i = 0; i < rings.length; i++) {
                if (visited[i] == 0) {
                    dfs(i, MoveType.LEFT);
                    dfs(i, MoveType.RIGHT);
                    groupCnt++;
                }
            }

            out.println("Arrays.toString(visited) = " + Arrays.toString(visited));

            int[] answer = {};
            return answer;
        }

        private void dfs(int index, MoveType moveType) {

            visited[index] = groupCnt;

            switch (moveType) {
                case LEFT:
                    int prevIndex = index - 1;
                    if (prevIndex == -1) {
                        prevIndex = rings.length - 1;
                    }

                    if (rings[index] == rings[prevIndex]) {
                        dfs(prevIndex, MoveType.RIGHT);
                    } else {
                        return;
                    }
                    break;
                case RIGHT:
                    int nextIndex = index + 1;
                    if (nextIndex == rings.length) {
                        nextIndex = 0;
                    }

                    if (rings[index] == rings[nextIndex]) {
                        dfs(nextIndex, MoveType.RIGHT);
                    } else {
                        return;
                    }
                    break;
            }
        }

        private enum MoveType {
            LEFT, RIGHT;
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
