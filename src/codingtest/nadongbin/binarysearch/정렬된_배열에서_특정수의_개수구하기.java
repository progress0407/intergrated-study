package codingtest.nadongbin.binarysearch;

import static java.lang.System.out;

public class 정렬된_배열에서_특정수의_개수구하기 {
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
            else if (find < x) mid = end - 1;
            else mid = start + 1;
        }

        out.println("mid = " + mid);

        int left = mid;
        while (arr[left] == x) left--;
        left++;

        int right = mid;
        while (arr[right] == x) right++;
        right--;

        out.println("right = " + right);
        out.println("left = " + left);

        out.println("(right-left +1) = " + (right - left + 1));

    }
}
