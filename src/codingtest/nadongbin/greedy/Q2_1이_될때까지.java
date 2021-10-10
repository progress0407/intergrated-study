package codingtest.nadongbin.greedy;

import java.util.Scanner;

import static java.lang.System.out;

public class Q2_1이_될때까지 {

    public static final String DIV = "나누기";
    public static final String SUB = "빼기";

    public static int N = 17; // 25
    public static int K = 4; // 3
    public static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        out.print("N 입력: ");
        N = sc.nextInt();
        out.print("K 입력: ");
        K = sc.nextInt();

//        풀이1();
        풀이2();

    }

    private static void 풀이2() {
        while (N != 1) {
            int before = N;
            String mode;
            if (N % K == 0) {
                mode = DIV;
                N /= K;
                cnt++;
            } else {
                mode = SUB;
                int diff = N % K;
                if (N - diff != 0) {
                    N -= diff;
                    cnt += diff;
                } else { // 빼고 난 후 0이면
                    N = 1;
                    cnt += (diff - 1);
                }
            }
            int after = N;
            out.printf("%s: %d -> %d \n", mode, before, after);
        }
        out.println("cnt = " + cnt);
    }

    private static void 풀이1() {
        while (N != 1) {
            int before = N;
            String mode;
            if (N % K == 0) {
                mode = DIV;
                N /= K;
            } else {
                mode = SUB;
                N--;
            }
            cnt++;
            int after = N;
            out.printf("%s: %d -> %d \n", mode, before, after);
        }
        out.println("cnt = " + cnt);
    }
}
