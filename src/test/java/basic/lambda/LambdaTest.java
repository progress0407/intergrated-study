package basic.lambda;

import static java.lang.System.out;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

public class LambdaTest {

    @Test
    void test() {
        Function<String, Integer> f = (String x) -> Integer.parseInt(x, 16); // f(FF) -> 255
        Function<Integer, String> g = (Integer x) -> Integer.toBinaryString(x); // g(255) -> 11111111

        out.println(f.apply("FF"));
        out.println(g.apply(255));

        Function<String, String> h = f.andThen(g); // h("FF") -> 11111111
        out.println(h.apply("FF"));
        Function<String, String> h2 = g.compose(f);
        out.println(h2.apply("FF"));
    }

    @Test
    void test2() {
        Predicate<Integer> p = x -> x < 100;
        Predicate<Integer> q = x -> x < 200;
        Predicate<Integer> r = x -> x % 2 == 0;
        Predicate<Integer> notP = p.negate();

        Predicate<Integer> all = notP.and(q.or(r));
        out.println(all.test(150));
    }

    @Test
    void test3() {
        BiPredicate<String, String> f = (a, b) -> a.equals(b);
        BiPredicate<String, String> f2 = String::equals;

        BiPredicate<String, String> g = (a, b) -> b.equals(a);
        BiPredicate<String, String> g2 = (a, b) -> b.equals(a);
        BiPredicate<String, String> g3 = (b, a) -> b.equals(a);
    }

    @Test
    void test4() {
        Runnable somethingDo = () -> out.println("풉ㅋ");
        somethingDo.run();
    }

    @Test
    void test5() {
        int a = 100;
        Runnable somethingDo = () -> {
//            int a = 20;
        };
    }

    @Test
    void test6() {
        int a = 100;
        Runnable somethingDo = () -> {
//            a = 20;
        };
    }

    private int b = 100;

    @Test
    void test7() {
        Runnable somethingDo = () -> {
            b = 20;
        };
    }
}
