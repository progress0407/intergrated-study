package test.grammer.reflection;

public class RefObject {

  private int numId;
  private int name;

  public static int staticMethod() {
    return 100;
  }

  public int getNumId() {
    return numId;
  }

  public void setNumId(int numId) {
    this.numId = numId;
  }

  class InnerClass {
    public void doo() {
    }

    public int doo2() {
      return 1;
    }
  }
}
