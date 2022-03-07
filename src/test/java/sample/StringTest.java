package sample;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

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
