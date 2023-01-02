package study.coding.test.backjoon.week_2;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * 틀린 풀이.. 그러나 이유를 알 수 없다
 * 정사각형에서 대각선 숫자들을 뺀 후 재정렬
 */

class Sol_3_23827_3 {

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
        for (int n = 0; n < array_size; n++) {
            nums[n] = Long.parseLong(strings[n]);
        }

        Arrays.sort(nums);

        long sum = 0;
        long sum_of_term_square = 0;
        for (int i = 0; i < array_size ; i++) {
            Long num = nums[i];
            sum += num;
            sum_of_term_square += (num * num);
        }
        sum *= sum;
        sum -= sum_of_term_square;
        sum /= 2;
        sum %= 1_000_000_007L;

        return sum + "";
    }
}
