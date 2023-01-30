package test.grammer.clazz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.System.out;

public class EqualAndHashMain {
    public static void main(String[] args) {
//        PrimitiveReferenceTypeTest();
        StringTest();
//        CustomObjectTest();
    }

    private static void CustomObjectTest() {
        Item apple = new Item(1_100_101L, "사과");
        Item apple2 = new Item(1_100_101L, "사 과");

        out.println("apple = " + apple);
        out.println("apple2 = " + apple2);

        out.println("apple.hashCode() = " + apple.hashCode());
        out.println("apple2.hashCode() = " + apple2.hashCode());

        out.println("System.identityHashCode(apple) = " + System.identityHashCode(apple));
        out.println("System.identityHashCode(apple2) = " + System.identityHashCode(apple2));

        out.println("Objects.equals(apple, apple2) = " + Objects.equals(apple, apple2));

        out.println("(apple == apple2) = " + (apple == apple2));

    }

    private static class Item {
        private final Long code;
        private final String name;

        public Item(final Long code, final String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(code);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Item)) return false;
            Item item = (Item) obj;
            return Objects.equals(this.code, item.code);
        }

    }

    private static void temp() {
        Map<Item, Long> itemStore = new HashMap<>(); // 상품이라는 키와 재고수량이라는 값

        itemStore.put(new Item(1_100_101L, "사과"), 6_900L);
        itemStore.put(new Item(1_100_102L, "바나나"), 8_500L);
        itemStore.put(new Item(1_100_103L, "천도복숭아"), 4_200L);
        itemStore.put(new Item(1_100_101L, "사 과"), 5_900L);


    }


    private static void StringTest() {
        String[] arr = {"Cho", "Seong", "Woo"};

        String[] arr2 = Arrays.copyOf(arr, 3); // Deep Copy

        out.println("arr.hashCode() = " + arr.hashCode());
        out.println("arr2.hashCode() = " + arr2.hashCode());

//        String a = "aa";
//        String a2 = "aa";

        String a = new String("aa");
        String a2 = new String("aa");

        out.println("a.hashCode() = " + a.hashCode());
        out.println("a2.hashCode() = " + a2.hashCode());

        out.println("System.identityHashCode(a) = " + System.identityHashCode(a));
        out.println("System.identityHashCode(a2) = " + System.identityHashCode(a2));

        out.println("(a == a2) = " + (a == a2));

        for (int i = 0; i < arr.length; i++) {
            out.printf("%d: %s == %s ?  %s \n", i, arr[i], arr2[i], arr[i].equals(arr2[i]));
        }
    }

    private static void PrimitiveReferenceTypeTest() {
        out.println("EqualAndHashMain.PrimitiveReferenceTypeTest");
        Integer a = 123;
        Integer b = 123;

        out.println("a==b = " + (a == b));
        out.println("a.equals(b) = " + a.equals(b));
        out.println("Objects.equals(a, b) = " + Objects.equals(a, b));
    }
}
