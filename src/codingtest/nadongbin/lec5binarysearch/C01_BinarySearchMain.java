package codingtest.nadongbin.lec5binarysearch;

import static java.lang.System.out;

public class C01_BinarySearchMain {
    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
        int n = 4;

        C01_BinarySearchMain search = new C01_BinarySearchMain();
//        search.binarySearch(arr, n);
//        int find = search.review(arr, n);

        int find = search.dfs(arr, n, 0, arr.length - 1);

        out.println("find = " + find);
    }

    private int dfs(int[] arr, int n, int start, int end) {

        if (start > end) {
            out.println("적당한 수를 찾지 못하였습니다");
            return -1;
        }
        
        int mid = (start + end) / 2;
        if (arr[mid] == n) {
            return mid;
        }
        if (arr[mid] > n) {
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }
        return dfs(arr, n, start, end);
    }

    private int review(int[] arr, int n) {

        int start = 0;
        int end = arr.length - 1;

        int mid = 0;
        while (start <= end) {
            
            mid = (start + end) / 2;
            if (arr[mid] == n) return mid;
            if (arr[mid] < n) {
                start = mid + 1;
                continue;
            }
            end = mid - 1;

        }

        // start > end
        out.println("적당한 수를 찾지 못하였습니다");
        return -1;
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
