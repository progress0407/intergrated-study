package study.coding.test.backjoon.week_5.two_pointer.Boj_1806;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 부분합
 */
class Main {

    public static void main(String[] args) {
        final Main main = new Main();
        final Reader reader = new InputStreamReader(System.in);
        String output = main.solve(reader);
        out.println(output);
        close(reader);
    }

    public String solve(final Reader reader) {
        final BufferedReader br = new BufferedReader(reader);

        final String[] firstInitStr = readStrArr(br);
        final int N = parseInt(firstInitStr[0]); // 개수
        final int S = parseInt(firstInitStr[1]); // 부분합
        int[] arr = new int[N];

        final String[] inputNums = read(br).split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = parseInt(inputNums[i]);
        }

        int en = 0;
        int min = N - 1;
        for (int st = 0; st < N; st++) {

            while (en < N && subTot(arr, en, st) < S) {
                en++; // 인덱스의 끝까지 증가
            }

            if (en == N) {
                break;
            }

            min = Math.min(min, en - st + 1);
        }

        return min + "";
    }

    private int subTot(final int[] arr, final int en, final int st) {
        int sum = 0;
        for (int i = st; i <= en; i++) {
            sum += arr[i];
        }
        return sum;
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
