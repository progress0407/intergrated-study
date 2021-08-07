package test.grammer.thread;

public class RunnableSample implements Runnable {

  int num = -1;

  public RunnableSample(int num) {
    this.num = num;
  }

  @Override
  public void run() {
    StringBuffer sb = new StringBuffer("RunnableSample ");
    sb.append(this.num);
    sb.append(" :  is running");
    System.out.println(sb);

  }

  public static void main(String[] args) {
    RunnableSample rn = new RunnableSample(1);
    RunnableSample rn2 = new RunnableSample(2);
    Thread th = new Thread(rn);
    Thread th2 = new Thread(rn2);
    th.start();
    th2.start();
  }
}
