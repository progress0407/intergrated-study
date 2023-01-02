package study.coding.test.backjoon.week_2;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Sol_3_23827_1 {

    /**
     * 두 수의 곱의 합을 1 000 000 007 로 나눈 나머지를 출력 !
     * <p>
     * int = 21억 21 0000 0000 2,100,000,000 2.1 * 10^9
     * <p>
     * 1.4 * 10^4
     * <p>
     * 500 000 = 5 * (10^5)
     *
     * 런타임 에러
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);

        String output = solve(reader);

        out.println(output);
    }

    public static String solve(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        int array_size = Integer.parseInt(br.readLine());

        ArrayList<Long> numbers = new ArrayList<>();

        String[] strings = br.readLine().split(" ");
        for (int i = 0; i < array_size; i++) {
            numbers.add(Long.parseLong(strings[i]));
        }

        int size = numbers.size();

        Set<Set<Long>> elementSets = new HashSet<>();

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                Long elementA = numbers.get(i);
                Long elementB = numbers.get(j);

                elementSets.add(Set.of(elementA, elementB));
            }
        }

        long totalSum = 0;
        for (Set<Long> elementSet : elementSets) {
            Long subSum =
                    elementSet.stream()
                            .reduce((a, b) -> a * b)
                            .get();

            totalSum += subSum;
        }

        totalSum %= 1_000_000_007;

        String output = String.valueOf(totalSum);
        return output;
    }

}
