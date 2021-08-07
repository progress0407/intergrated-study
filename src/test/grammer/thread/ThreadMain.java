package test.grammer.thread;

import java.util.Random;

public class ThreadMain {

  public static final int ThreadGenNum = 16;
  public static final int RetryNum = 5;

  public static void main(String[] args) {
    System.out.println("==== 쓰레드 생성 갯수 : " + ThreadGenNum + "====");
    for (int i = 0; i < RetryNum; i++) {
      long startMills = System.currentTimeMillis();
      runThread();
      long endMills = System.currentTimeMillis();
      long runMills = endMills - startMills;
      System.out.println("수행시간 = " + runMills + "ms");
    }

  }

  public static void runThread() {

    ArithmeticThread[] th = new ArithmeticThread[ThreadGenNum];
    CmmMemory cmmMemory = new CmmMemory();
    Long sum = 0L;

    for (int i = 0; i < ThreadGenNum; i++) {
      th[i] = new ArithmeticThread();
      th[i].setThreadGenNum(ThreadGenNum);
      th[i].start();
    }

    for (int i = 0; i < ThreadGenNum; i++) {
      try {
        th[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    for (int i = 0; i < ThreadGenNum; i++) {
      sum += th[i].getCnt();
    }

    System.out.print("total sum = " + sum + "  |  ");
  }
}
