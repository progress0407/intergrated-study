package designpattern.observer.n2;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;

public interface FamilyHouse {

  List<BroadcastStations> broadcastStationsList = new ArrayList<>();

  default void subscribe(BroadcastStations broadcastStations) {
    broadcastStationsList.add(broadcastStations);
    out.println(this.getClass().getSimpleName() + " : "
        +  broadcastStations.getClass().getSimpleName() + " 구독했당 !! 우앙 공부안해야징 ! ");
    broadcastStations.register(this);
  };

  default void unsubscribe(BroadcastStations bs) {

  };

  default void getMyBroadStList() {
    out.println("구독한 방송국 리스트 출력");
    broadcastStationsList
        .forEach(broadcastStationsOne
            -> out.println("name : " + broadcastStationsOne.getClass().getSimpleName()));
    out.println();
  }

  default void receiveCheck(String msg) {
    out.println(this.getClass().getSimpleName() + " : " + msg);
  }

}

class Simpsons implements FamilyHouse { }