package codingtest.nadongbin.wooteco;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Q2_청개구리 {
    public static void main(String[] args) {

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();

        List<String> reverseList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        // [1,2,3,4,5], [6,7,8,9,10]

        for (int i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf((char) i), String.valueOf((char) ('Z' - i + 'A')));
        }

        for (int i = 'a'; i <= 'z'; i++) {
            map.put(String.valueOf((char) i), String.valueOf((char) ('z' - i + 'a')));
        }

        Set<String> s1 = map.keySet();
        for (String s : s1) {
            out.printf("(%s, %s) ",s, map.get(s));
        }


        String str = "I love you";

        char[] chars = str.toCharArray();

        out.println("chars = " + chars);
        for (char aChar : chars) {
            String rev = "";
            if (aChar == ' ') {
                rev = " ";
            } else {
                rev = map.get(String.valueOf(aChar));
            }
            out.print(rev);
        }

    }
}
