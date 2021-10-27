package codingtest.nadongbin.greedy;

import java.util.Arrays;
import java.util.LinkedList;

import static java.lang.System.out;

public class Q6_만들수없는금액 {
    public static void main(String[] args) {
        /**
         * 1 2 4 5 6 7 9 10 11
         * 못만드는것 7
         */
        int[] in = {3, 2, 1, 1, 9};
        Arrays.sort(in);

        LinkedList<Integer> sums = new LinkedList<>();

        /**
         * 1 1 2 3 9
         * o
         *   o
         * o  o
         * o   o
         */
//        for (int n = 1; n <= in.length; n++) {
//            dfs(sums, in, n, 0, 0); // n번 더함 0번 인덱스부터, 합계 0
//        }

        dfs(sums, in, 2, 0, 0);

        // 5*4/2 = 10 개

        out.println("sums = " + sums);
        out.println("sums.size() = " + sums.size());
    }

    /**
     * @param sums
     * @param in
     * @param n 더할 횟수
     * @param index 더하기 시작할 인덱스
     * @param sum 더한 숫자
     */
    private static void dfs(LinkedList<Integer> sums, int[] in, int n, int index, int sum) {

        if (n == 0) {
            sums.add(sum);
            return;
        }

        for (int i = index + 1; i < in.length; i++) {
            out.println("index = " + index);
//            out.printf("dfs:: n-1= %d, index = %d, sum = %d\n", n - 1, i, sum + in[index]);
            dfs(sums, in, n - 1, i, sum + in[index]); // 현재 1값 더하기

        }

    }

}
