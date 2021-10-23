package codingtest.nadongbin.sortzz;

import static java.lang.System.out;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort selection = new SelectionSort();
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
//        selection.sort(arr);
        selection.sort2(arr);
    }

    // 나동빈님 것.. 인덱스 5일때 예외상황이 발생한다
    private void sort2(int[] arr) { 
        int length = arr.length;
        int minIndex = 0;
        int temp = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            printMap(arr);
            out.printf("%d: arr[%d]==min: %d \n", i, minIndex, arr[minIndex]);
            swap(arr, minIndex, i);
            printMap(arr);
            out.println();
        }
    }


    private void sort(int[] arr) {
        int length = arr.length;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            out.println("min = " + min);
            min = Integer.MAX_VALUE;
            swap(arr, minIndex, i);
            printMap(arr);
        }
    }

    private void printMap(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            out.printf("%3d", arr[j]);
        }
        out.println();
    }

    private void swap(int[] arr, int minIndex, int i) {
        int temp;
        temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
