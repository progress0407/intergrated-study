package codingtest.nadongbin.lec2greedy;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class Q3_곱하기_혹은_더하기 {

    public static String INPUT_STRING = "02984";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        out.println("입력: ");
        INPUT_STRING = sc.next();

        List<Integer> integers = Arrays.asList(INPUT_STRING.split("")).stream()
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        // 정렬 태운 것으로 재작성할것 -> sorted 안됨...
        // 1023 알고보니 맞았다 !

        Integer sum = integers.stream()
                .peek(out::println)
                .reduce((a, b) -> {
                    out.printf("[a, b] = %d %d \n", a, b);
                    if (a == 0 || a == 1 || b == 0 || b == 1) {
                        return a + b;
                    } else {
                        return a * b;
                    }
                }).get();

        out.println("sum = " + sum);

    }
}

