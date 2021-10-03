package test.grammer.collectionzz;

import java.util.*;

import static java.lang.System.*;

public class CollectionMain {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("A");

        out.println("list.indexOf(\"A\") = " + list.indexOf("A"));
        out.println("list.lastIndexOf(\"A\") = " + list.lastIndexOf("A"));

//        Object[] objects = list.toArray(new Object[]{});
        String[] strings = list.toArray(new String[0]);
//        Arrays.stream(objects).forEach(out::println);
        Arrays.stream(strings).forEach(out::println);

        out.println("====== removed ");
        list.remove(0);
        list.forEach(out::println);

        out.println("====== removed 2 ");
        out.println(list.remove("A"));
        list.forEach(out::println);

        out.println("list.remove(\"K\") = " + list.remove("K"));

        String[] strings1 = {"B", "C", "d"};
        List<String> toDeleteList = new ArrayList<>(Arrays.asList(strings1));
        toDeleteList.forEach(out::println);

        out.println("======= toDelete");
        list.removeAll(toDeleteList);
        list.forEach(out::println);

        list.add("A");

        out.println("======== set");
        String k = list.set(1, "K");
        out.println("k = " + k);
        list.forEach(out::println);

        out.println("======= to thread safe list");
        list = Collections.synchronizedList(new ArrayList<>());
        list.forEach(out::println);

        out.println("======= and add A");
        list.add("A");



    }

    private static void test1() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        List<String> list2 =
//                new ArrayList<>();        // Deep Copy
//                new ArrayList<>(list);      // Deep Copy
                list;                     // Shallow copy

//        list2.addAll(list);

        list.add(1 , "A1");

        out.println("========= 1 ========");
        out.println("==== list 1:");
        list.forEach(out::println);
        out.println("==== list 2:");
        list2.forEach(out::println);

        /*
        out.println("========= 2 ========");
        list.stream().forEach(out::println);

        out.println("========= 3 ========");
        list.iterator().forEachRemaining(out::println);
        */

    }
}
