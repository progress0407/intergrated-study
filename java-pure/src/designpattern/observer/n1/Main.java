package designpattern.observer.n1;

public class Main {

  public static void main(String[] args) {
    Badie badie = new Badie();
    Crew tiber = new Tiber();
    Crew jay = new Jay();
    Crew lewin = new Lewin();

    badie.subscribe(tiber);
    badie.subscribe(jay);
    badie.subscribe(lewin);

//    badie.upgradeCutie();
//    badie.eatFood();
//    badie.runaway();

    badie.notifyCrew("이 똥쟁이들앙!");

    badie.unsubscribe(jay);
    System.out.println();

    badie.notifyCrew("이 똥 맛잇냐!!");

  }

}
