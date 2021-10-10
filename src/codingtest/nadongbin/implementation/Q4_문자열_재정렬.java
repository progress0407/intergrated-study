package codingtest.nadongbin.implementation;

import java.util.*;

import static java.lang.System.out;

public class Q4_문자열_재정렬 {

    public static String INPUT_STRING = "";

    // 입력부터 정규식으로 나눠보기...

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        out.print("입력: ");
        INPUT_STRING = sc.next();

        char[] chars = INPUT_STRING.toCharArray();

        List<String> mixed = new ArrayList<>();

        for (char ch : chars) {
            mixed.add(String.valueOf(ch));
        }

        String alphabetString = mixed.stream()
                .sorted()
                .filter(e -> e.matches("[A-Z]"))
                .reduce((a, b) -> a + b)
                .orElseThrow(() -> new IllegalArgumentException("영문자가 없음"));


        Integer numberString = mixed.stream()
                .filter(e -> e.matches("[0-9]"))
                .map(e -> Integer.parseInt(e))
                .reduce((a, b) -> a + b)
                .get();

        String result = alphabetString + numberString;

        out.println("result = " + result);
    }

}
