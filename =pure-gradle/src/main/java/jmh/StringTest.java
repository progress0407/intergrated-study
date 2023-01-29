package jmh;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1)
@Measurement(iterations = 5)
//@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
@State(Scope.Benchmark)
public class StringTest {

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }

    @Benchmark
    public void string() {
        String word = "hello";
        String result = "";

        for (int i = 0; i < 1_000; i++) {
            result += word;
        }

    }

//    @Benchmark
    public void stringBuilder() {
        String word = "hello";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 1_000; i++) {
            sb.append(word);
        }
    }
}
