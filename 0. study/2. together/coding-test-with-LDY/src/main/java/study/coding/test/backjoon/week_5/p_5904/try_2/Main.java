package study.coding.test.backjoon.week_5.p_5904.try_2;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

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

        final String moo = "moo";

        final int N = parseInt(read(br));

        final StringBuilder sb = new StringBuilder(moo);

        int mooSize = 3;
        int totSize = mooSize;

        while (totSize < N) {
            mooSize++;
            totSize = 2 * totSize + mooSize;
        }

        return search(N-1, mooSize, totSize);
    }

    private String search(int N, int mooSize, int totSize) {
        int front = (totSize - mooSize) / 2;
        int back = totSize - front;

        // 앞
        if (N < front) {
            totSize = (totSize - mooSize) / 2;
            mooSize--;
            return search(N, mooSize, totSize);
        }
        // 가운데
        else if (N >= front && N < back) {
            if (N == front) {
                return "m";
            } else {
                return "o";
            }
        }
        // 뒤
        else {
            N -= back;
            totSize = (totSize - mooSize) / 2;
            mooSize--;
            return search(N, mooSize, totSize);
        }
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
