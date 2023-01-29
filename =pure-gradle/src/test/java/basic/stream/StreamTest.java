package basic.stream;

import static java.lang.System.out;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class StreamTest {

    @Test
    void test() {
        List.of(1, 2, 3, 4).stream()
                .map(num -> num * 2)
                .peek(out::println)
                .collect(Collectors.toList());
    }

    @Test
    void test2() {
        List.of(1, 2, 3, 4).stream()
                .map(num -> num * 2)
                .peek(out::println);
    }

    @Test
    void test3() {
//        Stream<Integer> integerStream = Stream.iterate(0, n -> n + 2);
//        integerStream.peek(out::println).count();

        Stream<Object> generate = Stream.generate(() -> 1);
        generate.peek(out::println).count();
    }

    @Test
    void test4() {
//        Stream<Path> list = Files.list(null);
//        Objects.isNull();
    }
}
