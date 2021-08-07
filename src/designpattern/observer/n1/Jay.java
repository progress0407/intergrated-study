package designpattern.observer.n1;

public class Jay implements Crew {

  @Override
  public void update(String msg) {
    System.out.println("Jay 수신 : " + msg);
  }
}
