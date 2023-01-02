package study.coding.test.backjoon.week_2;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 3번 풀이를 개량 long -> bigInteger
 */

class Sol_3_23827_6 {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);

        String output = solve(reader);

        out.println(output);
    }

    public static String solve(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        int array_size = Integer.parseInt(br.readLine());

        BigInteger[] nums = new BigInteger[array_size];

        String[] strings = br.readLine().split(" ");
        for (int n = 0; n < array_size; n++) {
            String num = strings[n];
            nums[n] = new BigInteger(num);
        }

        BigInteger sum = new BigInteger("0");
        BigInteger sum_of_term_square =  new BigInteger("0");
        for (int i = 0; i < array_size ; i++) {
            BigInteger num = nums[i];
            sum = sum.add(num);
            sum_of_term_square = sum_of_term_square.add(num.multiply(num));
        }
        sum = sum.multiply(sum);
        sum = sum.min(sum_of_term_square);
        sum = sum.divide(new BigInteger("2"));
        sum = sum.remainder(new BigInteger("1000000007"));

        return sum + "";
    }
}
