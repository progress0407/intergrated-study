package designpattern.observer.n2;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;

public abstract class BroadcastStations {

  List<FamilyHouse> subscriberList = new ArrayList<>();

  public void register(FamilyHouse fm) {
    subscriberList.add(fm);
    String msg = String.format("[%s] : %s님이 구독하였습니다.\n"
        , this.getClass().getSimpleName()
        , fm.getClass().getSimpleName());
    out.println(msg);
  }

  public void notifyFamilyies(String msg) {
    subscriberList.forEach(subscriberOne->subscriberOne.receiveCheck(msg));
  };
}

class Netflix extends BroadcastStations { }

class Watcha extends BroadcastStations { }