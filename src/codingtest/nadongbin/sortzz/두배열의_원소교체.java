package codingtest.nadongbin.sortzz;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * 5
 * 3
 * 1 2 5 4 3
 * 5 5 6 6 5
 */

public class 두배열의_원소교체 {
    public static void main(String[] args) {
        solve2();
//        solve1();
    }

    private static void solve2() {
        Scanner sc = new Scanner(System.in);
        out.print("n: ");
        int n = sc.nextInt();
        out.print("k: ");
        int k = sc.nextInt();

        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        out.print("a: ");
        for (int i = 0; i < n; i++) { // 띄어쓰기로 입력이 가능하다
            a[i] = sc.nextInt();
        }

        out.print("b: ");
        for (int i = 0; i < n; i++) { // 띄어쓰기로 입력이 가능하다
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        out.println("===== sorted =====");

        out.print("a: ");
        for (int i = 0; i < n; i++) {
            out.print(a[i] + " ");
        }
        out.print("\nb: ");
        for (int i = 0; i < n; i++) {
            out.print(b[i] + " ");
        }


        for (int i = 0; i < k; i++) {
            if (a[i] < b[i]) {
                swap(a, b, i);
            }
        }

        out.println("\n\n===== swaped =====");
        for (int i = 0; i < n; i++) {
            out.print(a[i] + " ");
        }

        out.print("\nb: ");
        for (int i = 0; i < n; i++) {
            out.print(b[i] + " ");
        }
    }

    private static void swap(Integer[] a, Integer[] b, int i) {
        int temp = a[i];
        a[i] = b[i];
        b[i] = temp;
    }

    private static void solve1() {
        int[] A = {1, 2, 5, 4, 3};
        int[] B = {5, 5, 6, 6, 5};

        int N = A.length;
        int K = 3;
        int min = 0;
        int max = 0;

        while (K-- >= 0) {
            for (int i = 0; i < N; i++) {
                if (A[min] > A[i]) {
                    min = i;
                }
            }

            for (int i = 0; i < N; i++) {
                if (B[max] < B[i]) {
                    max = i;
                }
            }

            swap(A, B, min, max);

            out.print("A: ");
            for (int i = 0; i < N; i++) {
                out.print(A[i] + " ");
            }
            out.print("\nB: ");
            for (int i = 0; i < N; i++) {
                out.print(B[i] + " ");
            }
            out.print("\n\n");
        }
    }

    private static void swap(int[] A, int[] B, int min, int max) {
        int temp = A[min];
        A[min] = B[max];
        B[max] = temp;
    }
}
