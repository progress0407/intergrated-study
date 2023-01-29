package simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Fork;

//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
//@State(Scope.Benchmark)
public class StringTest {

//    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }

//    @Benchmark
    @Test
    @DisplayName("스트링 연산")
    public void string() {
        String word = "hello";
        String result = "";

        for (int i = 0; i < 1_000; i++) {
            result += word;
        }
    }

//    @Benchmark
    @Test
    @DisplayName("StringBuilder 연산")
    public void stringBuilder() {
        String word = "hello";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 1_000; i++) {
            sb.append(word);
        }
    }
}
