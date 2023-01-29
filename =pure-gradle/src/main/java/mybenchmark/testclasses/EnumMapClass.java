package mybenchmark.testclasses;

import java.util.EnumMap;
import lombok.RequiredArgsConstructor;
import mybenchmark.MyBenchMark;

public class EnumMapClass implements MyBenchMark {

    private EnumMap<MyEnum, Integer> map;

    public EnumMapClass() {
        map = new EnumMap<>(MyEnum.class);
        for (MyEnum value : MyEnum.values()) {
            map.put(value, value.num);
        }
    }

    @Override
    public void test() throws RuntimeException {
        final int myEnumSize = MyEnum.values().length;
        for (int i = 0; i < NUMBER_OF_TRIALS / myEnumSize; i++) {
            for (MyEnum value : MyEnum.values()) {
                map.get(value);
            }
        }
    }

    @RequiredArgsConstructor
    private enum MyEnum {
        N1(1), N2(2), N3(3), N4(4), N5(5), N6(6), N7(7), N8(8), N9(9), N10(10);
        private final int num;
    }
}
