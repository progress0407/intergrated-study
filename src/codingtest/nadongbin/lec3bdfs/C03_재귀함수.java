package codingtest.nadongbin.lec3bdfs;

import static java.lang.System.out;

public class C03_재귀함수 {
    public static void main(String[] args) {
//        recursive_fn(1);
//        int result = recursiveFactory(5);
//        out.println("result = " + result);

        recursive_유클리드호제법(192, 168);
    }

    private static void recursive_유클리드호제법(int a, int b) {
        int r = a % b;
        if (r == 0) {
            out.printf("호제법 결과 : %d, %d \n", a, b);
            return;
        }

        recursive_유클리드호제법(b, r);
    }


    private static int recursiveFactory(int n) {
        if (n == 1) return 1;

        return n * recursiveFactory(n - 1);
    }

    private static void recursive_fn(int n) {
        if (n == 10) return;

        out.printf("%d 에서 %d 호출 \n", n, n + 1);
        recursive_fn(n + 1);
        out.printf("%d 종료 \n", n);
    }
}
