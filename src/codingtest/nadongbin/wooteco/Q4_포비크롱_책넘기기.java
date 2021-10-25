package codingtest.nadongbin.wooteco;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

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
        int solution = sol.solution(pobi, crong);
        out.println("solution = " + solution);
    }

    static class Solution {

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
