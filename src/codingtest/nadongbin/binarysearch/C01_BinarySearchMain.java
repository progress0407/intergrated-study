package codingtest.nadongbin.binarysearch;

import static java.lang.System.out;

public class C01_BinarySearchMain {
    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        int n = 4;

        C01_BinarySearchMain search = new C01_BinarySearchMain();
        search.binarySearch(arr, n);
    }

    private int binarySearch(int[] arr, int n) {

        int start = 0;
        int end = arr.length - 1;
        int mid = (0 + end) / 2;

        while (true) {

            if(n!= arr[mid] && start == end) break; // 못찾은경우

            if (n == arr[mid]) {
                out.println("index = " + mid);
                return mid;
            } else if (n < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }

        out.println("찾는 수 없음");
        return -1;
    }
}
