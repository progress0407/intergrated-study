package codingtest.nadongbin.bdfs;

import static java.lang.System.out;

public class SelfSummation {
    public static void main(String[] args) {
        int sum = sum(100, 0);
        out.println("sum = " + sum);
//        int sum = sum2(10);
//        out.println("sum = " + sum);
    }

    static int sum(int n, int sum) {
        out.printf("n = %d, sum = %d \n", n, sum);
        if (n==1) return sum + 1;
        return sum(n - 1, sum + n);
    }

    static int sum2(int n) {
        if (n == 1) return 1;
        return n + sum2(n - 1);
    }

}
