package mybenchmark;

public interface MyBenchMark {
    int REP_COUNT = 10_000_000;
    void test() throws RuntimeException;
}
