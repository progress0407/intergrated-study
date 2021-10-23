package codingtest.nadongbin.sortzz;

import java.util.Scanner;

import static java.lang.System.out;

public class Prg_가장큰수 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        out.print("n 입력: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        out.print("배열 입력: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        sol.solution(numbers);

    }

    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            for (int i = 0; i < numbers.length; i++) {
                char[] chars = String.valueOf(numbers[i]).toCharArray();

                out.println("numbers[i] = " + numbers[i]);

                for (char aChar : chars) {
                    out.println("aChar = " + aChar);
                    out.println("(int) aChar = " + (aChar - '0'));
                }
            }

            return answer;
        }
    }

}
