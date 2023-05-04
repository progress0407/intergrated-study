package mybenchmark;

import mybenchmark.testclasses.EnumMapClass;
import mybenchmark.testclasses.HashMapClass;

public class Main {
    public static void main(final String... args) {
        MyBenchMark benchMark = new EnumMapClass();
//        MyBenchMark benchMark = new HashMapClass();

        MyBenchMarkRunner benchMarkRunner = new MyBenchMarkRunner(benchMark);
        benchMarkRunner.run();
    }
}
