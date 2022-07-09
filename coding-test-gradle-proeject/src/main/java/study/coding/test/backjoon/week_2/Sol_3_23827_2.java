package study.coding.test.backjoon.week_2;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 시간 초과 !
 * 1억번 계산 가능 =
 * 1 00 000 000
 * 10^8
 *
 * 5*10^5
 */

class Sol_3_23827_2 {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);

        String output = solve(reader);

        out.println(output);
    }

    public static String solve(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        int array_size = Integer.parseInt(br.readLine());

        Long[] numbers = new Long[array_size];

        String[] strings = br.readLine().split(" ");
        for (int n = 0; n < array_size; n++) {
            numbers[n] = Long.parseLong(strings[n]);
        }

        Arrays.sort(numbers);

        int total = 0;
        for (int i = 0; i < array_size - 1; i++) {
            int subTotal = 0;
            for (int j = i + 1; j < array_size; j++) {
                subTotal += numbers[j];
            }
            total += numbers[i] * subTotal;
        }

        return total + "";
    }

}
