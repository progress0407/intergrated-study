package codingtest.nadongbin.sort;

import java.util.LinkedList;

import static java.lang.System.out;

/**
 * 삽입 정렬은 교환이 아닌 앞으로 데이터를 끼워 넣는 것이다
 * -> LinkedList 로 가자
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        InsertionSort sort = new InsertionSort();
//        sort.sort(arr);
        sort.sort2(arr);
    }


    private void sort2(int[] arr) { // 나동빈님 풀이

        int length = arr.length;
        for (int i = 1; i < length; i++) { // 선택된 친구
            for (int j = i; j > 0; j--) { // 비교 대상들
                if (arr[j] < arr[j - 1]) {
                    out.printf("arr[%d], arr[%d] = %d, %d \n", j, j - 1, arr[j], arr[j - 1]);
                    swap(arr, j);
                } else {
                    break;
                }
            }
            printArr(arr);
        }
    }

    private void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
    }

    private void sort(int[] arr) {
//        ArrayList<Integer> list = new ArrayList<>(List.of(7, 5, 9, 0, 3, 1, 6, 2, 4, 8));
        LinkedList<Integer> list = new LinkedList<>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            list.add(arr[i]);
        }
//        list.addFirst(list.remove(3));

        for (int i = 1; i < length; i++) { // 선택된 곳
            for (int j = 0; j < i ; j++) { // 비교 대상들
                if (list.get(i) < list.get(j)) {
                    printList(list);
                    Integer remove = list.remove(i);
                    out.printf("i=%d, j=%d, remove = %d \n", i, j, remove);
                    list.add(j, remove);
                    printList(list);
                    out.println();
                }
            }
        }
    }

    private void printList(LinkedList<Integer> list) {
        for (int k = 0; k < list.size(); k++) {
            out.printf("%3d", list.get(k));
        }
        out.println();
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.printf("%3d", arr[i]);
        }
        out.println();
    }

}
