package mybenchmark.testclasses;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import mybenchmark.MyBenchMark;

public class HashMapClass implements MyBenchMark {

    private Map<Integer, Integer> map;

    public HashMapClass() {
        map = new HashMap<>();
        IntStream.rangeClosed(1, REP_COUNT).forEach(value -> map.put(value, value));
    }

    @Override
    public void test() {
        map();
    }

    private void map() {
        IntStream.rangeClosed(1, REP_COUNT).forEach(value -> map.get(value));
    }
}
