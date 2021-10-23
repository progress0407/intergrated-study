package codingtest.nadongbin.sortzz;

import static java.lang.System.out;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};

        CountingSort countingSort = new CountingSort();
        countingSort.sort(arr);
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
