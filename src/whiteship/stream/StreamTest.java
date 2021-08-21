package whiteship.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

        stream = list.stream();
        stream.map(e-> {
            System.out.println("#1 e = " + e);
            return Integer.parseInt(e);
        }).forEach(x -> {
            System.out.println("#2 x = " + x);
        });
    }
}
