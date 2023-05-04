package mybenchmark;

import static java.lang.System.out;

public class MyBenchMarkRunner {

    private final MyBenchMark benchMark;

    private static final int NUMBER_OF_REPETITIONS = 10;

    public MyBenchMarkRunner(MyBenchMark benchMark) {
        this.benchMark = benchMark;
    }

    public void run() {
        long resultSum = 0L;
        try {
            for (int i = 0; i < NUMBER_OF_REPETITIONS; i++) {
                long start = System.currentTimeMillis();
                benchMark.test();
                long elapsedTime = System.currentTimeMillis() - start;
                out.printf("elapsedTime :  %d ms \n", elapsedTime);
                resultSum += elapsedTime;
            }
        } catch (RuntimeException e) {
            out.println(e.getMessage());
        }
        double avgTime = (double) resultSum / NUMBER_OF_REPETITIONS;
        out.printf("\n %d회 반복 평균 시간 :  %.2f ms \n", NUMBER_OF_REPETITIONS, avgTime);
    }
}
