package whiteship.java8to11.interfacelambda;

import java.util.Arrays;
import java.util.Random;
import java.util.function.*;

import static java.lang.System.*;

public class lambdaMain {

    public static void main(String[] args) {
//        lec1();
//        lec2();
//        self1();
//        lec3();
//        lec4();
//        self2();
        self3();
    }

    private static void self3() {
        ToIntFunction<String> fn = str -> Integer.parseInt(str);
        int result = fn.applyAsInt("123");
        out.println("result = " + result);
    }

    private static void lec4() {
        String[] names = {"bb", "aa", "cc"};
        Arrays.sort(names, String::compareToIgnoreCase);
        out.println(Arrays.toString(names));
    }

    private static void lec3() {
        UnaryOperator<String> hi = Greeting::hi;
        out.println("hi.apply(\"swcho\") = " + hi.apply("swcho"));

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        out.println("hello.apply(\"swcho\") = " + hello.apply("swcho"));

        Supplier<Greeting> newGreetingSupplier = Greeting::new;
        Greeting newGreeting = newGreetingSupplier.get();// 여기서 생성된다

        Function<String, Greeting> swCho = Greeting::new;
        Greeting swcho = swCho.apply("swcho");
        out.println("swcho.getName() = " + swcho.getName());
    }

    private static void self1() {
        // 사용자 정의 FunctionalInterface
        TriAdd<Integer, Integer, Double, Double> triAdd = (a, b, c) -> a + b * c;
        Double result = triAdd.returnAdd(100, 8, 1.5);
        out.println("result = " + result);
    }

    private static void lec2() {
        Plus10NotLambda p = new Plus10NotLambda();
        out.println("p.apply(3) = " + p.apply(3));

//        Function<Integer, Integer> plus10 = n -> n + 10;
        UnaryOperator<Integer> plus10 = n -> n + 10;
        Function<Integer, Integer> multiply2 = n -> 2 * n;

        // f 합성 g: g ->f
        Integer multiply2AndPlus10 = plus10.compose(multiply2).apply(3);
        Integer plus10AndMultiply2 = multiply2.compose(plus10).apply(3);

        out.println("plus10.compose(multiply2).apply(3) = " + multiply2AndPlus10); // 16
        out.println("multiply2.compose(plus10).apply(3) = " + plus10AndMultiply2); // 26

        // f 다음 g: f->g
        out.println("plus10.andThen(multiply2).apply(3) = " + plus10.andThen(multiply2).apply(3)); // 26
        out.println("multiply2.andThen(plus10).apply(3) = " + multiply2.andThen(plus10).apply(3)); // 16

        Consumer<Integer> printT = (i) -> out.println("i = " + i);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 10;
        out.println("get10.get() = " + get10.get());

        Predicate<String> startWithCho = (s) -> s.startsWith("cho");
        out.println("startWithCho.test(\"choMini\") = " + startWithCho.test("choMini"));
        out.println("startWithCho.test(\"joeMini\") = " + startWithCho.test("joeMini"));

        Predicate<String> endWithSw = (s) -> s.endsWith("Sw");

        Predicate<String> isChoAndSw = startWithCho.and(endWithSw);
        out.println("isChoAndSw.test(\"choMiniSw\") = " + isChoAndSw.test("choMiniSw"));
        out.println("isChoAndSw.test(\"joeMiniSw\") = " + isChoAndSw.test("joeMiniSw"));

        Predicate<Integer> isEven =  (i) -> i%2 == 0;
        out.println("isEven.test(3) = " + isEven.test(3));
        out.println("isEven.test(4) = " + isEven.test(4));

//        BiFunction<Integer, Integer, Integer> plusEachOther = (a, b) -> a + b;
        BinaryOperator<Integer> plusEachOther = (a, b) -> a + b;
        out.println("plusEachOther.apply(3,7) = " + plusEachOther.apply(3, 7));

        BiPredicate<Integer, Integer> sameEachOther = (a, b) -> a == b;
        out.println("sameEachOther.test(5,5) = " + sameEachOther.test(5, 5));

        BiConsumer<String, Integer> printNTimes = (s, n) -> {
            for(int i=0; i< n; i++) out.println(s);
        };

        printNTimes.accept("foo", 3);

        BooleanSupplier randBool = () -> (new Random()).nextBoolean();
        for (int i=0; i<3; i++) out.println("randBool.getAsBoolean() = " + randBool.getAsBoolean());


    }

    private static void lec1() {
        RunSomething runSomething = new RunSomething() {

            int baseNum = 100;

            @Override
            public int doIt(int a) {
                baseNum -= a;
                return baseNum;
            }
        };

        out.println("runSomething.doIt(3) = " + runSomething.doIt(3));
        out.println("runSomething.doIt(3) = " + runSomething.doIt(3));
        out.println("runSomething.doIt(3) = " + runSomething.doIt(3));
    }

}
