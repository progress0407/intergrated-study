package test.grammer.thread;

public class ThreadSapmle extends Thread {
  int num = -1;
  int sum = 0;

  public void setNum(int num) {
    this.num = num;
  }

  @Override
  public void run() {
    StringBuffer sb = new StringBuffer("ThreadSample ");
    sb.append(this.num);
    sb.append(" :  is running");

    System.out.println(sb);
  }
}
