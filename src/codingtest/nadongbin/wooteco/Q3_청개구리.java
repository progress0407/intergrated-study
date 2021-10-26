package codingtest.nadongbin.wooteco;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Q3_청개구리 {
    public static void main(String[] args) {

//        solve1();
        solve2();

    }

    private static void solve2() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        for (int i = 'a'; i <= 'z'; i++) {
            map.put(String.valueOf((char) (i)), String.valueOf((char) ('z' - i + 'a')));
        }

        for (int i = 'A'; i < 'Z'; i++) {
            map.put(String.valueOf((char) i), String.valueOf((char) ('Z' - (i - 'A'))));
        }

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            out.print(" " + key);
        }

        out.println();
        Collection<String> values = map.values();
        values.stream().forEach(e -> out.printf(" " + e));


        String str = "I love you";

        String[] strs = str.split("");

//        LinkedList<String> result = new LinkedList();

        List<String> result = Arrays.stream(strs).map(e -> {
            if (e.equals(" ")) {
                return " ";
            } else {
                return map.get(e);
            }
        }).collect(Collectors.toList());

        out.println();
        result.forEach(e -> out.print(e));

//        for (String key : strs) {
//            if (key.equals(" ")) {
//                result.add(" ");
//                continue;
//            }
//            result.add(map.get(key));
//        }
//        out.println();
//        result.forEach(e -> out.print(e));
    }

    private static void solve1() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();

        List<String> reverseList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        /**
         * [1,2,3,4,5], [6,7,8,9,10]
         * [1,2],[3,4]..
         */


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

        // str.split("")
        // 배열 나눌때는 저렇게 해서 char[] 말고
//        Stream.of(str.split(""))

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
