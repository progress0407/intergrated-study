package codingtest.nadongbin.sort;

import static java.lang.System.out;

public class BubbleSort {
    public static void main(String[] args) {

        BubbleSort bubble = new BubbleSort();

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        bubble.sort(arr);
        printMap(arr);
    }

    private static void printMap(int[] arr) {
        for (int i : arr) {
            out.println("i = " + i);
        }
    }

    private void sort(int[] arr) {

        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j);
                }
            }
        }
    }

    private void swap(int[] arr, int i) {
        int temp;
        temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }
}
