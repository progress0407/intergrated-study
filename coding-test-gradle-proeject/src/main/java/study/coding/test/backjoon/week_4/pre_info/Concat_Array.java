package study.coding.test.backjoon.week_4.pre_info;

import static java.lang.System.out;

import java.util.Arrays;

public class Concat_Array {

    public static void main(String[] args) {

//        case1();

        case2();
    }

    private static void case2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        int index = 3;

        final int[] result = cherryKill(arr, index);

        out.println("result = " + Arrays.toString(result));
    }

    private static int[] cherryKill(final int[] arr, final int index) {
        final int[] copyArr = Arrays.copyOfRange(arr, 0, index);
        final int[] copyArr2 = Arrays.copyOfRange(arr, index + 1, arr.length);

        final int[] result = concatArray(copyArr, copyArr2);
        return result;
    }

    private static void case1() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};

        // 0, 1, 2
        final int[] copyArr = Arrays.copyOfRange(arr, 0, 3);
        // 3,4,5,6
        final int[] copyArr2 = Arrays.copyOfRange(arr, 3, 7);

        out.println("arr = " + Arrays.toString(arr));
        out.println("copyArr = " + Arrays.toString(copyArr));

        arr[0] = 101;

        out.println("--- after op ---");

        out.println("arr = " + Arrays.toString(arr));
        out.println("copyArr = " + Arrays.toString(copyArr));

        concatArray(copyArr, copyArr2);
    }

    private static int[] concatArray(final int[] copyArr, final int[] copyArr2) {
        final int[] result = Arrays.copyOf(copyArr, copyArr.length + copyArr2.length);
        System.arraycopy(copyArr2, 0, result, copyArr.length, copyArr2.length);
        return result;
    }
}
