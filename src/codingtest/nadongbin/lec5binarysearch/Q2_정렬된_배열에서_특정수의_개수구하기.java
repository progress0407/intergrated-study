package codingtest.nadongbin.lec5binarysearch;

import static java.lang.System.out;

public class Q2_정렬된_배열에서_특정수의_개수구하기 {

    public static void main(String[] args) {

        int n = 7;
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;

        int start = 0;
        int end = n - 1;

        int mid = -1;

        while (start <= end) {
            mid = (start + end) / 2;
            int find = arr[mid];

            if (find == x) break;
            else if (find < x) end = mid - 1;
            else start = mid + 1;
        }

        out.println("mid = " + mid);

        // (log2_N + k2-k1)

        int left = mid;
        while (arr[left] == x) left--;
        left++; // left = 2

        int right = mid;
        while (arr[right] == x) right++;
        right--; // right = 5

        out.println("right = " + right);
        out.println("left = " + left);

        out.println("(right-left +1) = " + (right - left + 1));

    }
}
