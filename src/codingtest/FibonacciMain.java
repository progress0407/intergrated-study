package codingtest;

import java.util.Arrays;

public class FibonacciMain {

    private int[] val = new int[100];

    public FibonacciMain() {
        this.val[1] = 1;
        this.val[2] = 1;
    }

    public static void main(String[] args) {

        FibonacciMain fibo = new FibonacciMain();
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d | %d\n", i, fibo.calc(i));
        }
        fibo.printVal();
    }

    public int calc(int n) {
        if (n == 1) {
            return val[1];
        } else if (n == 2) {
            return val[2];
        }
        else if (val[n] > 0) {
            return val[n];
        }
        val[n] = calc(n - 1) + calc(n - 2);
        return val[n];
    }

    public void printVal() {
        Arrays.stream(val).forEach(System.out::println);
    }
}

