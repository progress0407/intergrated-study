package codingtest.nadongbin.sort;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

// 계수 정렬
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};

        CountingSort countingSort = new CountingSort();

        countingSort.sort(arr);
        countingSort.review(arr);

    }

    private void review(int[] arr) {

        int length = arr.length;
        int[] count = new int[length + 1];

        for (int i = 0; i < length; i++) {
            int num = arr[i];
            count[num]++;
        }

        out.println("Arrays.toString(count) = " + Arrays.toString(count));

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                out.print(i + " ");
                list.add(i);
            }
        }

        out.println("======================");
        list.forEach(out::println);

    }

    private void sort(int[] arr) { // 내풀이와 나동빈님 풀이가 동일
        int[] countArr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i];
            countArr[n]++;
        }

        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
//                out.printf("%3d", i);
                out.print(i + " ");
            }
        }
        out.println();
    }
}
