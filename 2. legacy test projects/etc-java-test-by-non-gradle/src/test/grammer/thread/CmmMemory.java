package test.grammer.thread;

public class CmmMemory {

  private Long cnt = 0L;
  private Object lock_001 = new Object();

  public Long getCnt() {
    return cnt;
  }

  public void setCnt(Long cnt) {
    this.cnt = cnt;
  }

   public void addCnt() {
//     this.cnt++;
    synchronized (lock_001) {
      this.cnt++;
    }
   }
}
