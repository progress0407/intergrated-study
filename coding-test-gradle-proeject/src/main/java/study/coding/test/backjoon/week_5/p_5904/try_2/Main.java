package study.coding.test.backjoon.week_5.p_5904.try_1;

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

        int k = 1;
        while (sb.length() < N) {
            recursive(sb, k);
        }

        return sb.charAt(N - 1) + "";
    }

    private void recursive(final StringBuilder sb, final int k) {
        final StringBuilder before = new StringBuilder(sb);
        StringBuilder newMoo = makeNewMoo(k);
        sb.append(newMoo);
        sb.append(before);
    }

    private StringBuilder makeNewMoo(final int k) {
        StringBuilder newMoo = new StringBuilder("m");
        for (int i = 0; i < k + 2; i++) {
            newMoo.append("o");
        }
        return newMoo;
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
