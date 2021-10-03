package whiteship.java8to11.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.*;

public class StreamMain {
    public static void main(String[] args) {
//        lect1();
        lect2();
//        self1();
    }

    private static void self1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 100);
        map.replace("apple", 300);
        map.put("banana", 500);

        List<Map<String, Integer>> list = new ArrayList<>();
        list.add(map);

        List<Map<String, Integer>> list2 = List.copyOf(list); // 깊은 복사

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("melon", 250);
        map2.put("watermelon", 350);
        list.set(0, map2);

        out.println("list = " + list);
        out.println("list2 = " + list2);


    }

    private static void lect2() {
        List<OnlineClass> springClass = new ArrayList<>();
        springClass.add(new OnlineClass(1, "spring boot", true));
        springClass.add(new OnlineClass(2, "spring data jpa", true));
        springClass.add(new OnlineClass(3, "spring mvc", false));
        springClass.add(new OnlineClass(4, "spring core", false));
        springClass.add(new OnlineClass(5, "rest api development", false));

        out.println("spring 으로 시작하는 수업");
        // TODO
        springClass.stream()
                .filter(s -> s.getTitle().startsWith("spring"))
                .collect(Collectors.toList())
                .forEach(out::println);

        out.println("close 되지 않은 수업");
        // TODO
//        springClass.stream().filter(s -> !s.isClosed()).forEach(out::println);
        springClass.stream().filter(Predicate.not(OnlineClass::isClosed)).forEach(out::println);

        out.println("수업 이름만 모아서 스트림 만들기");
        // TODO
//        springClass.stream().map(s -> s.getTitle()).forEach(out::println);
        springClass.stream().map(OnlineClass::getTitle).forEach(out::println);

        List<OnlineClass> javaClass = new ArrayList<>();
        javaClass.add(new OnlineClass(6, "The Java Test", true));
        javaClass.add(new OnlineClass(7, "The Java Code manipulation", true));
        javaClass.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvent = new ArrayList<>();
        keesunEvent.add(springClass);
        keesunEvent.add(javaClass);

        out.println("두 수업 목록에 있는 모든 수업 아이디 출력");
//        keesunEvent.stream().flatMap(e -> e.stream()).map(e -> e.getTitle()).forEach(out::println);
        keesunEvent.stream()
                .flatMap(Collection::stream) /** list -> list.stream() */
                .forEach(oc -> out.println(oc.getTitle()));


        List<List<OnlineClass>> keesunEvent2 = List.copyOf(keesunEvent); // 깊은 복사
        keesunEvent2.stream()
                .flatMap(Collection::stream)
                .forEach(oc -> out.println(oc.getTitle()));

        // 위 두 리스트를 포함하는 리스트
        List<List<List<OnlineClass>>> superKeesunEvent = new ArrayList<>();
        superKeesunEvent.add(keesunEvent);
        superKeesunEvent.add(keesunEvent2);

        out.println("========= superKeesunEvent ==========");

        superKeesunEvent.stream()
                .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .forEach(oc -> out.println(oc.getTitle()));

        out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 20개 빼고 최대 30개까지만");
        // TODO
//        IntStream.range(1, 10).forEach(out::println);
        Stream.iterate(10, i -> i + 1) // 10부터 1씩 증가하는 무제한 스트림
                .skip(20) // 앞에 20개 빼고
                .limit(30) // 최대 30개 까지만
                .forEach(out::println);

        out.println("자바 수업 중에 Test가 들어 있는 수업이 있는지 확인");

        /**
        javaClass.stream()
                .filter(oc -> oc.getTitle().toUpperCase().contains("TEST"))
                .forEach(out::println);
         */
        boolean test = javaClass.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        out.println(test);


        out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");

        /**
        springClass.stream()
                .filter(oc -> oc.getTitle().toUpperCase().contains("SPRING"))
                .forEach(out::println);
         */
        List<String> spring = springClass.stream()
                .map(OnlineClass::getTitle)
                .filter(t -> t.contains("spring"))
                .collect(Collectors.toList());

        spring.forEach(out::println);


    }


    private static void lect1() {
        List<String> names = new ArrayList<>();
        names.add("swcho");
        names.add("starcraft");
        names.add("blizzard");

//        Stream<String> stringStream = names.stream().map(String::toUpperCase);
//        Stream<String> stringStream = names.stream().map((s) -> {
//            out.println(s);
//            return s.toUpperCase();
//        });
        List<String> list = names.stream().map((s) -> {
            out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());

        out.println("-----------");

        names.forEach(out::println);
        list.forEach(out::println);

        for (String name : names) {
            if (name.startsWith("s")) {
                out.println("name.toUpperCase() = " + name.toUpperCase());
            }
        }

        // 데이터가 정말 방대할 때... pararellStream
        List<String> collect = names.parallelStream().map((s) -> {
            out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(out::println);
    }
}
