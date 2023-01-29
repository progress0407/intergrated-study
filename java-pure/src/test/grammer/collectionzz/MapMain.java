package test.grammer.collectionzz;

import java.util.*;

import static java.lang.System.out;

public class MapMain {
    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
//        test4();
    }

    private static void test4() {
        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            out.printf("%s = %s \n", entry.getKey(), entry.getValue());
        }
    }

    private static void test3() {
        Map<InnerNested, Integer> itemStore = new HashMap<>();

        itemStore.put(new InnerNested(101L, "바나나"), 12_000);
        itemStore.put(new InnerNested(102L, "사과"), 15_000);
        itemStore.put(new InnerNested(103L, "파인애플"), 9_000);

        itemStore.put(new InnerNested(101L, "바나나"), 6_000); // 요게 저장되면 안된다 !
        itemStore.put(new InnerNested(101L, "바나 나"), 8_000); // 이것도 저장되지 않기를 원한다

        for (Map.Entry<InnerNested, Integer> entry : itemStore.entrySet()) {
            InnerNested nested = entry.getKey();
            out.printf("%s : %s : %s \n", nested.getCode(), nested.getName(), entry.getValue());
        }
    }

    static class InnerNested {

        private Long code;
        private String name;

        public InnerNested(Long code, String name) {
            this.code = code;
            this.name = name;
        }

        public Long getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            InnerNested nested = (InnerNested) obj;
            if (nested.code.equals(this.code)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
//            return Objects.hash(name, code);
            return Objects.hash(name);
        }

    }

    private static void test2() {

        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("A", 1);
        map.put("가", 2);
        map.put("1", 3);
        map.put("a", 4);
        // 1 A a 가
        // 3 1 4 2

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            out.printf("%s : %d \n", entry.getKey(), entry.getValue());
        }


    }

    private static void test1() {
//        Map<String, Integer> map = new HashMap<>();
        // 동기화된 HashMap
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
        map.put("a", 1);
        map.put("b", 2);
        map.put("a", 10); // 키가 동일할 경우 치환된다

        out.println("map.get(\"a\") = " + map.get("a"));

        Set<String> keySet = map.keySet();
        out.println("keySet = " + keySet);

        out.println("===== all entries print");
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        entries.forEach(out::println);

        out.println("map.size() = " + map.size());
    }
}
