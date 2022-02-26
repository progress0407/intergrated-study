package mybenchmark;

public interface MyBenchMark {
    int NUMBER_OF_TRIALS = 10_000_000;
    void test() throws RuntimeException;
}
