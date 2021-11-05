package codingtest.dongbinna.lec4sort;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.out;

public class Q1_두배열의_원소교체_연습 {

    private static int[] A = {1, 2, 5, 4, 3};
    private static int[] B = {5, 5, 6, 6, 5};
    private static int k = 3;

    public static void main(String[] args) {

        review();
    }

    private static void review() {

        Integer[] As = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer[] Bs = Arrays.stream(B).boxed().sorted(Comparator.reverseOrder()).toArray(Integer[]::new);

        for (int i = 0; i < k; i++) {
            swap(As, Bs, i);
        }

        out.println("Arrays.toString(As) = " + Arrays.toString(As));
        out.println("Arrays.toString(Bs) = " + Arrays.toString(Bs));
    }

    private static void swap(Integer[] As, Integer[] Bs, int i) {
        int temp = As[i];
        As[i] = Bs[i];
        Bs[i] = temp;
    }
}
