package codingtest.nadongbin.lec1implementation;

import java.util.Scanner;

import static java.lang.System.out;


public class Q2_시각 {

    public static final int MAX_HOUR = 24;
    public static final int MAX_MINUTE = 60;
    public static final int MAX_SECOND = 60;

    public static int N = 3;

    public static String INPUT_NUM;
    public static int searchCnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        out.print("검색할 숫자를 입력하시오: ");
//        INPUT_NUM = String.valueOf(sc.nextInt());

//        풀이1();
//        풀이2();
        풀이3();
    }

    private static void 풀이3() {

        int cnt = 0;
        for (int h = 0; h < MAX_HOUR; h++) {
            for (int m = 0; m < MAX_MINUTE; m++) {
                for (int s = 0; s < MAX_SECOND; s++) {
                    if (checkTime(h, m, s)) {
                        cnt++;
                    }
                }
            }
        }

        out.println("cnt: " + cnt);
    }

    private static boolean checkTime(int h, int m, int s) {
        if (h % 10 == N || m / 10 == N || m % 10 == N || s / 10 == N || s % 10 == N) {
            return true;
        }
        return false;
    }

    private static void 풀이2() {

        int cnt = 0;

        for (int i = 0; i < MAX_HOUR; i++) {
            for (int j = 0; j < MAX_MINUTE; j++) {
                for (int k = 0; k < MAX_SECOND; k++) {
                    String time = String.format("%d : %d : %d", i, j, k);
                    if (time.contains("3")) {
                        out.println("time = " + time);
                        cnt++;
                    }
                }
            }
        }

        out.println("cnt = " + cnt);
    }

    private static void 풀이1() { // 검색 최적화
        for (int i = 0; i < MAX_HOUR; i++) {

            String hour = String.valueOf(i);

            if (hour.contains(INPUT_NUM)) {
                searchCnt += MAX_MINUTE * MAX_SECOND;
                continue;
            }

            for (int j = 0; j < MAX_MINUTE; j++) {

                String minute = String.valueOf(j);

                if (minute.contains(INPUT_NUM)) {
                    searchCnt += MAX_SECOND;
                    continue;
                }

                for (int k = 0; k < MAX_SECOND; k++) {
                    String second = String.valueOf(k);
                    if (second.contains(INPUT_NUM)) {
                        searchCnt++;
                        continue;
                    }
                }
            }
        }

        out.println("searchCnt = " + searchCnt);
    }
}
