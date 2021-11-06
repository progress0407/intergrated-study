package codingtest.wooteco.gen4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static java.lang.System.in;
import static java.lang.System.out;

public class Q4_DFS {

    public static void main(String[] args) {

        Solution sol = new Solution();

        String s = "aaabbaaa";
//        String s = "wowwow";
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

            /**
             * [0,1,2, 5,6,7]
             * [3,4]
             */
            List<List<Integer>> superIndexList = new ArrayList<>();
            for (int i = 0; i < rings.length; i++) {
                if (visited[i] == 0) {
                    List<Integer> indexList = new ArrayList<>();
                    dfs(i, MoveType.BOTH, indexList);
                    superIndexList.add(indexList);
                }
            }

//            out.println("Arrays.toString(visited) = " + Arrays.toString(visited));
//            out.println("superIndexList = " + superIndexList);

            int[] answer = superIndexList.stream().mapToInt(List::size).sorted().toArray();

//            out.println("answer = " + Arrays.toString(answer));

            return answer;
        }

        private void dfs(int index, MoveType moveType, List<Integer> indexList) {

            visited[index] = 1;
            indexList.add(index);

            int prevIndex = index - 1;
            int nextIndex = index + 1;
            switch (moveType) {
                case LEFT:
                    moveLeft(index, indexList, prevIndex);
                    break;
                case RIGHT:
                    moveRight(index, indexList, nextIndex);
                    break;
                case BOTH: // 초기, 둘다 가는 경우
                    moveLeft(index, indexList, prevIndex);
                    moveRight(index, indexList, nextIndex);
                    break;
            }
        }

        private void moveRight(int index, List<Integer> indexList, int nextIndex) {
            if (nextIndex == rings.length) {
                nextIndex = 0;
            }

            if (visited[nextIndex] == 0 && rings[index] == rings[nextIndex]) {
                dfs(nextIndex, MoveType.RIGHT, indexList);
            } else {
                return;
            }
        }

        private void moveLeft(int index, List<Integer> indexList, int prevIndex) {
            if (prevIndex == -1) {
                prevIndex = rings.length - 1;
            }

            // 방문하지 않고 원소가 같은 곳만을 방문
            if (visited[prevIndex] == 0 && rings[index] == rings[prevIndex]) {
                dfs(prevIndex, MoveType.LEFT, indexList);
            } else {
                return;
            }
        }

        private enum MoveType {
            LEFT, RIGHT, BOTH;
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
