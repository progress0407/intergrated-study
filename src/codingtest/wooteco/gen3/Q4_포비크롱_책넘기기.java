package codingtest.wooteco.gen3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * [97, 98],  [197,198]
 * [131, 132], [211, 212]
 * [99, 102], [211, 212]
 */
public class Q4_포비크롱_책넘기기 {
    public static void main(String[] args) {

//        int[] pobi = {97, 98};
//        int[] crong = {197, 198};

        int[] pobi = {131, 132};
        int[] crong = {211, 212};

//        int[] pobi = {99, 102};
//        int[] crong = {211, 212};


        Solution sol = new Solution();
        int solution = sol.solution2(pobi, crong);
        out.println("solution = " + solution);

    }

    static class Solution {

        public int solution2(int[] pobi, int[] crong) {
            if (!validation(pobi) || !validation(crong)) return -1;

            int pobiMax = calc(pobi);
            int crongMax = calc(crong);

            out.println("pobiMax = " + pobiMax);
            out.println("crongMax = " + crongMax);

            int result = pobiMax > crongMax ? 1 : pobiMax < crongMax ? 2 : 0;

            return result;
        }

        private int calc(int[] pobi) {

            List<Integer> list = new ArrayList<>();

            Integer left = pobi[0];
            int[] leftSplit = Arrays.stream(left.toString().split("")).mapToInt(Integer::parseInt).toArray();

            int leftSum = Arrays.stream(leftSplit).reduce(Integer::sum).getAsInt();
            list.add(leftSum);

            int leftMul = Arrays.stream(leftSplit).reduce((a, b) -> a * b).getAsInt();
            list.add(leftMul);


            Integer right = pobi[1];
            int[] rightSplit = Arrays.stream(right.toString().split("")).mapToInt(Integer::parseInt).toArray();

            int rightSum = Arrays.stream(rightSplit).reduce(Integer::sum).getAsInt();
            list.add(rightSum);

            int rightMul = Arrays.stream(rightSplit).reduce((a, b) -> a * b).getAsInt();
            list.add(rightMul);

            int max = list.stream().mapToInt(e->e).max().getAsInt();

            return max;
        }

        private boolean validation(int[] pages) {
            int left = pages[0];
            int right = pages[1];

            if (!(left + 1 == right)) return false;
            if (left == 1 || right == 400) return false;
            if (!(left % 2 == 1 && right % 2 == 0)) return false;

            return true;
        }

        public int solution(int[] pobi, int[] crong) {

            if (!canSolve(pobi)) {
                return -1;
            }

            int[] pobiLeft = Arrays.stream(String.valueOf(pobi[0]).split("")).mapToInt(Integer::parseInt).toArray();
            int[] pobiRight = Arrays.stream(String.valueOf(pobi[1]).split("")).mapToInt(Integer::parseInt).toArray();

            int[] pobiResult = new int[4];
            pobiResult[1] = 1;
            pobiResult[3] = 1;

            for (int i = 0; i < pobiLeft.length; i++) {
                pobiResult[0] += pobiLeft[i];
                pobiResult[1] *= pobiLeft[i];
            }

            for (int i = 0; i < pobiRight.length; i++) {
                pobiResult[2] += pobiRight[i];
                pobiResult[3] *= pobiRight[i];
            }

            out.println("Arrays.toString(pobiResult) = " + Arrays.toString(pobiResult));

            int[] crongResult = new int[4];
            crongResult[1] = 1;
            crongResult[3] = 1;

            int[] crongLeft = Arrays.stream(String.valueOf(crong[0]).split("")).mapToInt(Integer::parseInt).toArray();
            int[] crongRight = Arrays.stream(String.valueOf(crong[1]).split("")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < crongLeft.length; i++) {
                crongResult[0] += crongLeft[i];
                crongResult[1] *= crongLeft[i];
            }

            for (int i = 0; i < crongRight.length; i++) {
                crongResult[2] += crongRight[i];
                crongResult[3] *= crongRight[i];
            }
            out.println("Arrays.toString(crongResult) = " + Arrays.toString(crongResult));

            int pobiMax = 0;
            for (int i = 0; i < pobiResult.length; i++) {
                if (pobiMax < pobiResult[i]) {
                    pobiMax = pobiResult[i];
                }
            }

            out.println("pobiMax = " + pobiMax);

            int crongMax = 0;
            for (int i = 0; i < crongResult.length; i++) {
                if (crongMax < crongResult[i]) {
                    crongMax = crongResult[i];
                }
            }

            out.println("crongMax = " + crongMax);

            if (pobiMax > crongMax) {
                return 1;
            } else if (pobiMax == crongMax) {
                return 0;
            }
            return 2;
        }

        private boolean canSolve(int[] pobi) {
            return pobi[0] % 2 == 1 && pobi[1] == pobi[0] + 1;
        }
    }
}
