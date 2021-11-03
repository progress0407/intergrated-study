package codingtest.programmers.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Prg_체육복 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        Scanner sc = new Scanner(System.in);

        int n = 5;
        int[] lost = {2, 4};
        int[] reverse = {1, 3, 5};

//        sol.solution(n, lost, reverse);
        sol.solution2(n, lost, reverse);
    }

    static class Solution {

        public int solution2(int n, int[] lost, int[] reserve) {

            Arrays.sort(lost);
            Arrays.sort(reserve);

            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] == reserve[j]) {
                        lost[i] = 0;
                        reserve[j] = 0;
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < lost.length; i++) {
                if(lost[i] == 0) continue;
                for (int j = 0; j < reserve.length; j++) {
                    if(reserve[j] == 0) continue;
                    if (Math.abs(lost[i] - reserve[j]) <= 1) {
                        lost[i] = 0;
                        reserve[j] = 0;
                        cnt++;
                    }
                }
            }

            out.println("Arrays.toString(lost) = " + Arrays.toString(lost));
            out.println("Arrays.toString(reserve) = " + Arrays.toString(reserve));
            out.println("cnt + reserve.length = " + (cnt + reserve.length));

            return cnt + reserve.length;
        }

        public int solution(int n, int[] lostInput, int[] reserveInput) {

            List<Integer> lost = Arrays.stream(lostInput).boxed().sorted().collect(Collectors.toList());
            List<Integer> reserve = Arrays.stream(reserveInput).boxed().sorted().collect(Collectors.toList());

            for (int i = 0; i < lost.size(); i++) {
                for (int j = 0; j < reserve.size(); j++) {
                    if (lost.get(i).equals(reserve.get(j))) {
                        lost.remove(i);
                        reserve.remove(j--);
                    }
                }
            }

            int answer = 0;
            return answer;
        }
    }
}
