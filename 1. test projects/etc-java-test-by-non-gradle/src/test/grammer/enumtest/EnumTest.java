package test.grammer.enumtest;

import java.util.Arrays;

public class EnumTest {
    public static void main(String[] args) {
        Long l = 1_234_567L;
        System.out.println("l = " + l);
//        Fruit fruit = Fruit.getEnumByCode(4L);
        for (Fruit fruit : Fruit.values()) {
            fruit.name = "바봉";
            System.out.println("fruit.name = " + fruit.name);
            System.out.println("fruit.getName() = " + fruit.getName());
            System.out.println("fruit.ordinal() = " + fruit.ordinal());
//            System.out.println("fruit.compareTo(Fruit.MANGO) = " + fruit.compareTo(Fruit.APPLE));
        }

        for (Fruit fruit : Fruit.values()) {
            System.out.println("fruit.name = " + fruit.name);
        }

//        CodeEnum[] enums = (CodeEnum[]) Fruit.class.getClass().getEnumConstants();

//        CodeEnum[] enums = (CodeEnum[]) Enum.class.getClass().getEnumConstants();

    }
}

class Tt {

}

enum Fruit implements CodeEnum {
    APPLE(1L, "사과"),
    BANANA(2L, "바나나"),
    KIWI(3L, "키외"),
    MANGO(4L, "망고");

    Long code;
    String name;

    Fruit(long code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }

    public static Fruit getEnumByCode(Long code) {
        return Arrays.stream(Fruit.values())
                .filter(e -> e.getCode() == code)
                .findAny()
                .orElseGet(null);
    }
}

interface CodeEnum {
    Long getCode();
}

