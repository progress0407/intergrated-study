package test.grammer;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class JustTmp {

  static String name;

  static int data ;

  static {
    System.out.println("*** static first ***");
  }

  static {
    System.out.println("*** static second ***");
  }

  public JustTmp() {
  }

  public JustTmp(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    JustTmp justTmp = new JustTmp();
    justTmp.checkName();
  }

  public void checkName() {
    JustTmp aa = new JustTmp("aa");
    System.out.println("aa.name = " + aa.name);
    JustTmp bb = new JustTmp("bb");
    System.out.println("bb.name = " + bb.name);
  }
}
