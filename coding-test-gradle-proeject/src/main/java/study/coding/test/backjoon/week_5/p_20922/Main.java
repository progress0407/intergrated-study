package study.coding.test.backjoon.week_5.p_20922;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        final Main main = new Main();
        final Reader reader = new InputStreamReader(System.in);
        String output = main.solve(reader);
        System.out.println(output);
        close(reader);
    }

    public String solve(final Reader reader) {
        final BufferedReader br = new BufferedReader(reader);
        final String[] firstLine = readStrArr(br);
        final int N = parseInt(firstLine[0]);
        final int K = parseInt(firstLine[1]);

        int[] arr = new int[N];

        final String[] secondLine = readStrArr(br);
        for (int i = 0; i < secondLine.length; i++) {
            arr[i] = parseInt(secondLine[i]);
        }

        int[] cnt = new int[100_000 + 1];
        Arrays.fill(cnt, 0);

        int st = 0;
        int en = 0;
        int max = 0;

        cnt[arr[0]]++;
        while (st < N) {

            while (en < N && cnt[arr[en]] <= K) {
                en++;
                if (en == N) {
                    break;
                }
                cnt[arr[en]]++;
                if (cnt[arr[en]] > K) {
                    break;
                }
                max = Math.max(max, en - st + 1);
            }

            if (en == N) {
                break;
            }

            while (st <= en && cnt[arr[en]] > K) {
                cnt[arr[st]]--;
                st++;
            }
        }

        return max + "";
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
