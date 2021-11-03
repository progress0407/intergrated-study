package codingtest.nadongbin.lec6dp;

import static java.lang.System.out;

public class C1_FibonacciMain {
    public static void main(String[] args) {
        C1_FibonacciMain fibo = new C1_FibonacciMain();
        // 1 1 2 3 5 8 13
        long start = System.currentTimeMillis();
        int n = 45;
        fibo.init(n);
//        int calc = fibo.calc(n);
        int calc = fibo.calcAscending(n);
        long end = System.currentTimeMillis();
        out.println("calc = " + calc);
        out.println("(end-start) = " + (end - start)/1000.0);

    }

    int[] d;

    private void init(int n) {
        d = new int[n + 1];
    }

    // 보텀업
    private int calcAscending(int n) {

        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[n];
    }

    private int calc(int n) {
        if (n == 1 || n == 2) return 1;
        return calc(n - 1) + calc(n - 2);
    }

}
