package codingtest.wooteco.gen4;

import java.util.Arrays;

import static java.lang.System.out;

public class Sample_직사각형 {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        sol.solution(v);
    }
    static class Solution {
        public int[] solution(int[][] v) {


            out.println("Arrays.toString(v) = " + Arrays.deepToString(v));

            int[][] xArr = getArr(v, 0);
            findSame(xArr);
            int x = findAlone(xArr);

            int[][] yArr = getArr(v, 1);
            findSame(yArr);
            out.println("Arrays.deepToString(yArr) = " + Arrays.deepToString(yArr));
            int y = findAlone(yArr);

            out.println("x = " + x);
            out.println("y = " + y);

            int[] answer = {x, y};
            out.println("answer = " + answer);
            return answer;
        }

        private int findAlone(int[][] arr) {
            int o = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i][1] == 0) {
                    o = arr[i][0];
                }
            }
            return o;
        }

        private void findSame(int[][] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i][0] == arr[j][0]) {
                        arr[i][1] = 1;
                        arr[j][1] = 1;
                    }
                }
            }
        }

        private int[][] getArr(int[][] v, int index) {
            int[][] arr = new int[v.length][];

            for (int i = 0; i < v.length; i++) {
                arr[i] = new int[2];
            }

            for (int i = 0; i < v.length; i++) {
                arr[i][0] = v[i][index];
            }
            return arr;
        }
    }
}
