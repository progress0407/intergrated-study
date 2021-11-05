package codingtest.dongbinna.lec6dp;

import static java.lang.System.out;

public class Q1_개미전사 {
    public static void main(String[] args) {
        int[] in = {1, 3, 1, 5};
        solution1(in);
    }

    private static void solution1(int[] in) {

        int[] stock = new int[in.length + 1];

        for (int i = 1; i < stock.length; i++) {
            stock[i] = in[i - 1];
        }

        int[] d = new int[stock.length + 1];

        /**
         * d[1]=1
         * d[2]=3
         * d[3] = max(d[1] + stock[3], d[2])
         *
         * d[n+2] = max(d[n] + stock[n+2], d[n+1])
         *
         * d[n] = max( d[n-2] + stock[n-1], d[n-1] )
         */

        d[1] = stock[1];
        d[2] = Math.max(stock[2], d[1]);

        for (int i = 3; i < stock.length; i++) {
            d[i] = Math.max(d[i - 2] + stock[i], d[i - 1]);
        }

        int end = d[stock.length - 1];

        out.println("end = " + end);
    }

}
