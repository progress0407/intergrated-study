package study.coding.test.backjoon.week_5.two_pointer.Boj_2230;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import static java.util.Arrays.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {

    public static void main(String[] args) {
        final Main main = new Main();
        final Reader reader = new InputStreamReader(System.in);
        String output = main.solve2(reader);
        out.println(output);
        close(reader);
    }

    public String solve(final Reader reader) {
        final BufferedReader br = new BufferedReader(reader);

        final String[] firstInitStr = readStrArr(br);
        final int N = parseInt(firstInitStr[0]); // 개수
        final int M = parseInt(firstInitStr[0]); // 차이
        final int[] num = new int[M];

        for (int i = 0; i < N; i++) {
            num[i] = parseInt(read(br));
        }

        sort(num);

        final int max = num[N - 1] - num[0];
        int min = max;
        for (int st = 0; st < N; st++) {

            for (int en = st; en < N; en++) {
                final int little = num[st];
                final int big = num[en];
                final int diff = big - little;
                if (diff >= M) {
                    min = Math.min(diff, min);
                    break;
                }
            }
        }

        return min + "";
    }

    /**
     * 강사님 문제 풀이
     */
    public String solve2(final Reader reader) {
        final BufferedReader br = new BufferedReader(reader);

        final String[] firstInitStr = readStrArr(br);
        final int N = parseInt(firstInitStr[0]); // 개수
        final int M = parseInt(firstInitStr[0]); // 차이
        final int[] num = new int[M];

        for (int i = 0; i < N; i++) {
            num[i] = parseInt(read(br));
        }

        sort(num);

        final int max = num[N - 1] - num[0];
        int min = max;

        int en  = 0;
        for (int st = 0; st < N; st++) {

            final int diff = num[en] - num[st];
            while (en < N && diff < M) {
                en++;
            }
            if (en == N) {
                break;
            }
            min = Math.min(min, diff);
        }

        return String.valueOf(min);
    }

    private String[] readStrArr(final BufferedReader br) {
        return read(br).split(" ");
    }

    private String read(final BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void close(final Reader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
