package study.coding.test.backjoon.week_2;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * 영운이 문제 풀이 참고
 */

class Sol_3_23827_4 {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);

        String output = solve(reader);

        out.println(output);
    }

    public static String solve(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        int array_size = Integer.parseInt(br.readLine());

        long[] nums = new long[array_size];

        String[] strings = br.readLine().split(" ");
        long sum = 0;
        for (int n = 0; n < array_size; n++) {
            nums[n] = Long.parseLong(strings[n]);
            sum += nums[n];
        }

        long result = 0;
        for (int i = 0; i < array_size; i++) {
            long num = nums[i];
            sum -= num;
            result += num * sum;
        }

        result %= 1_000_000_007L;

        return String.valueOf(result);
    }
}
