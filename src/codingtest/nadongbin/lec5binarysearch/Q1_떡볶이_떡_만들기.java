package codingtest.nadongbin.lec5binarysearch;

import java.util.Arrays;

import static java.lang.System.out;

public class Q1_떡볶이_떡_만들기 {
    public static void main(String[] args) {
//        solve1();
        int want = 8;
        int height = review(want);
        out.println("height = " + height);
    }

    private static int review(int want) {
        int[] heights = {19, 14, 10, 17};

        Arrays.sort(heights);

        int start = 0;
        int length = heights.length;
        int end = heights[length - 1];

        while (start <= end) {
            int mid = (start + end) / 2;

            int silceSum = getSilceSum(heights, mid);

            if(silceSum == want) return mid;

            if (silceSum > want) {
                start = mid + 1;
                continue;
            }
            end = mid - 1;
        }

        out.println("만족할 수 있는 떡의 길이가 존재하지 않습니다");
        return -1;
    }

    private static int getSilceSum(int[] heights, int mid) {
        return Arrays.stream(heights)
                .filter(h -> h >= mid)
                .map(e->e-mid)
                .reduce(Integer::sum)
                .orElseThrow();
    }

    private static void solve1() {
        //        Scanner sc = new Scanner(System.in);
//        out.print("n 입력: ");
//        int n = sc.nextInt();
//        out.print("떡 입력: ");
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }

        int n = 4;
        int[] arr = {19, 14, 10, 17};

//        int max = arr[0];
//        for (int i = 1; i < n; i++) {
//            max = Math.max(max, arr[i]);
//        }

        int max = Arrays.stream(arr).max().orElse(-1);

        int start = 0;
        int end = max;
        int mid = -1;
        int k = 6;

        int dduck = -1;
        while (start <= end) {

            mid = (start + end) / 2;

            dduck = getDduk(arr, mid);

            if (dduck == k) {
                break;
            } else if (dduck < k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        out.println("cut = " + mid);
    }

    private static int getDduk(int[] arr, int cut) {

        int[] slice = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > cut) {
                slice[i] = arr[i] - cut;
            }
        }
        return Arrays.stream(slice).sum();
    }
}
