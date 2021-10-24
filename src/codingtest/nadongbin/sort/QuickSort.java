package codingtest.nadongbin.sort;

import static java.lang.System.out;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort.sort(arr);

    }


    private void sort(int[] arr) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        print(arr);
//        dfs(arr, startIndex, endIndex);
        dfs2(arr, startIndex, endIndex);

    }

    private void dfs2(int[] arr, int start, int end) { // 나동빈님 풀이

        if (start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            // 피벗보다 큰수 찾기
            while (left <= end && arr[left] <= arr[pivot]) left++;
            // 작은수 찾기
            while (right >= start && arr[right] >= arr[pivot]) right--;


            print(arr);
            if (left > right) { // 엇갈린 경우
                out.println("엇갈림");
                swap(arr, pivot, right);
            } else {
                out.println("안 엇갈림");
                swap(arr, left, right);
            }

        }

        dfs2(arr, start, right - 1);
        dfs(arr, right + 1, end);

    }

    private void dfs(int[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex || startIndex == -1) { // 정렬할 대상이 하나이거나 인덱스 엇갈리면 탈출
            return;
        }

        int smallIndex = -1; // 작거나 같은 것
        int largeIndex = -1;

        int pivotIndex = startIndex;

        while (true) {

            // 큰것 찾기
            for (int i = startIndex + 1; i < endIndex; i++) {
                if (arr[pivotIndex] < arr[i]) {
                    largeIndex = i;
                    break;
                }
            }

            // 작거나 같은것 찾기
            for (int i = endIndex; i >= 0; i--) {
                if (arr[pivotIndex] >= arr[i]) {
                    smallIndex = i;
                    break;
                }
            }

            print(arr);

            // index 엇갈림 비교
            if (largeIndex > smallIndex || largeIndex == -1) { // 얻갈린 경우, 큰 값을 찾지 못한 경우
                swap(arr, smallIndex, pivotIndex);
                break;
            } else { // 엇갈리지 않은 경우
                swap(arr, smallIndex, largeIndex);
            }
        }

        dfs(arr, startIndex, smallIndex - 1);
        dfs(arr, smallIndex + 1, endIndex);
    }

    private void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.printf("%3d", arr[i]);
        }

        out.println();
    }

    private void swap(int[] arr, int smallIndex, int pivotIndex) {
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[smallIndex];
        arr[smallIndex] = temp;
    }
}
