package simple.random;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RandomTest {

    public static final int MAX = 10_000_000;

    public static final int RND_MAX = 30_000;

    public static void main(String[] args) {
        final RandomTest randomTest = new RandomTest();
        final Random random = new Random();
        randomTest.doRandom("일반 Random", () -> random.nextInt(RND_MAX));
        sleep();
        randomTest.doRandom("ThreadLocalRandom", () -> ThreadLocalRandom.current().nextInt(RND_MAX));
        System.out.println("hello world");
    }

    private static void sleep() {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void doRandom(final String workName, final Supplier<Integer> randomGen) {
        System.out.println("[WORK] = " + workName);

        final ExecutorService threadPool = Executors.newFixedThreadPool(50);
        final Future<ResultSet> future = threadPool.submit(() -> getCallback(randomGen));

        final ResultSet resultSet;
        try {
            resultSet = future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("resultSet = " + resultSet);
    }

    private ResultSet getCallback(final Supplier<Integer> randomGen) {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        int avg = 0;
        int[] nums = new int[MAX];
        sum = sum(randomGen, sum, nums);
        avg = sum / MAX;
        long diffSquareSum = diffSquareSum(avg, nums);
        final long vX = diffSquareSum / MAX;
        long elapsedTime = System.currentTimeMillis() - startTime;

        return new ResultSet(avg, vX, elapsedTime);
    }

    private int sum(final Supplier<Integer> randomGen, int sum, final int[] nums) {
        for (int i = 0; i < MAX; i++) {
            final int rnd = randomGen.get();
            sum += rnd;
            nums[i] = rnd;
        }
        return sum;
    }

    private long diffSquareSum(final int avg, final int[] nums) {
        long diffSquareSum = 0;
        int trialCnt = 0;
        for (final int num : nums) {
            final int diff = (num - avg);
            final int diffSquare = diff * diff;
            diffSquareSum += diffSquare;
            trialCnt++;
        }
        System.out.println("trialCnt = " + trialCnt);
        return diffSquareSum;
    }

    private static class ResultSet {

        public int avg;
        public long vX;
        public long elapsedTime;

        public ResultSet(final int avg, final long vX, final long elapsedTime) {
            this.avg = avg;
            this.vX = vX;
            this.elapsedTime = elapsedTime;
        }

        @Override
        public String toString() {
            return "ResultSet{" +
                    "avg=" + avg +
                    ", vX=" + vX +
                    ", elapsedTime=" + elapsedTime +
                    '}';
        }
    }
}
