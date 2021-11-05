package codingtest.dongbinna.lec6dp;

import java.util.Arrays;

import static java.lang.System.out;

public class Q3_효율적인_화폐 {
    public static void main(String[] args) {
        int n = 15;
//        solve(n);
        solve2(n);
    }

    private static void solve2(int n) {
        int[] d = new int[n + 1];

        Arrays.fill(d, 10001);

        int[] arr = {2, 3, 5};

        int k = 1;
        for (int e : arr) {
            if (k * e <= n) {
                d[k * e] = Math.min(k, d[k * e]);
            }
        }

        out.println("Arrays.toString(d) = " + Arrays.toString(d));
    }

    private static void solve(int n) {

        int[] d = new int[n + 1];

        d[2] = 1;
        d[3] = 1;
        d[4] = 1;

        for (int i = 5; i <= n; i++) {
            d[i] = Math.min(d[i - 2] + d[2], d[i - 3] + d[3]);
        }

        out.println("Arrays.toString(d) = " + Arrays.toString(d));

    }

}
