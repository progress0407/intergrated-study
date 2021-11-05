package codingtest.dongbinna.lec1implementation;

import java.util.*;

import static java.lang.System.out;

public class Q4_문자열_재정렬 {

    public static String INPUT_STRING = "";

    // 입력부터 정규식으로 나눠보기...

    public static void main(String[] args) {

//        solve();
        review();
    }

    private static void review() {
        String in = "K1KA5CB7";

//        PriorityQueue<Character> alphas = new PriorityQueue<>((a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));
        List<Character> alphas = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < in.length(); i++) {
            Character c = in.charAt(i);
            if (Character.isAlphabetic(c)) alphas.add(c);
            else if (Character.isDigit(c)) sum += (c - '0');
        }

        Collections.sort(alphas);
        out.println("alphas = " + alphas);
        out.println("sum = " + sum);

        String result = alphas.stream().map(String::valueOf).reduce((a, b) -> a + b).orElseThrow();
        result += sum;

        out.println("result = " + result);

    }

    private static void solve() {

        // K1KA5CB7
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
