package codingtest.programmers.bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class Prg_모의고사 {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] answer = {1,2,3,4,5};
//        int[] answer = {1, 3, 2, 4, 2};


        sol.solution(answer);

    }

    static class Solution {
        public int[] solution(int[] answers) {

            int[] person1 = {1, 2, 3, 4, 5};
            int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


            int[] answerCount = new int[3];
            for (int i = 0; i < answers.length; i++) {
                if (person1[i % person1.length] == answers[i]) {
                    answerCount[0]++;
                }
                if (person2[i % person2.length] == answers[i]) {
                    answerCount[1]++;
                }
                if (person3[i % person3.length] == answers[i]) {
                    answerCount[2]++;
                }
            }


            List<Integer> results = new ArrayList<>();
            int max = Arrays.stream(answerCount).max().getAsInt();

            for (int i = 0; i < answerCount.length; i++) {
                if (answerCount[i] == max) {
                    results.add(i + 1);
                }
            }

            int[] ints = results.stream().sorted().mapToInt(e -> e).toArray();
            out.println("ints = " + Arrays.toString(ints));
            return ints;
        }
    }
}
