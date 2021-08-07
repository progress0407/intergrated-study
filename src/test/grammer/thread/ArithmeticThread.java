package test.grammer.thread;

public class ArithmeticThread extends Thread {

  private int cnt = 0;
  private int ThreadGenNum;
  private static final Long totalRepetitions = 1200000000L;

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public void setThreadGenNum(int threadGenNum) {
    this.ThreadGenNum = threadGenNum;
  }

  @Override
  public void run() {

    Long repetitions = totalRepetitions / ThreadGenNum;

    for (int i = 0; i < repetitions; i++) {
      cnt++;
    }
  }
}
