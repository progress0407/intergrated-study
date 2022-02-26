package mybenchmark;

import static java.lang.System.out;

public class MyBenchMarkRunner {

    private final MyBenchMark benchMark;

    private static final int REP_TIMES = 10;

    public MyBenchMarkRunner(MyBenchMark benchMark) {
        this.benchMark = benchMark;
    }

    public void run() {
        long resultSum = 0L;
        try {
            for (int i = 0; i < REP_TIMES; i++) {
                long start = System.currentTimeMillis();
                benchMark.test();
                long elapsedTime = System.currentTimeMillis() - start;
                out.println("elapsedTime = " + elapsedTime);
                resultSum += elapsedTime;
            }
        } catch (RuntimeException e) {
            out.println(e.getMessage());
        }
        out.printf("avg :  %.1f", ((double) resultSum / REP_TIMES));
    }
}
