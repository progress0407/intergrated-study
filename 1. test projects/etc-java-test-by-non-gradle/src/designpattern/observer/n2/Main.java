package designpattern.observer.n2;

public class Main {

  public static void main(String[] args) {

    BroadcastStations netflix = new Netflix();
    BroadcastStations watcha = new Watcha();

    FamilyHouse simpsons = new Simpsons();
    simpsons.subscribe(netflix);
    simpsons.subscribe(watcha);
    simpsons.getMyBroadStList();


//    netflix.notifyFamilyies("tt"); // 수신되었음 출력
    watcha.notifyFamilyies("tt2");
  }
}
