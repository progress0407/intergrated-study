package designpattern.observer.n1;

import java.util.ArrayList;
import java.util.List;

public class Badie implements Coach {

  private List<Crew> crews = new ArrayList<Crew>();

  public void eatFood() {
    System.out.println("베디코치가 밥을 먹는다.");
    notifyCrew("나 밥먹었따");
  }

  public void runaway() {
    System.out.println("베디코치가 농땡이를 친다.");
    notifyCrew("나 농땡이 쳤따");
  }

  public void upgradeCutie() {
    System.out.println("베디코치가 귀여움을 강화했다.");
    notifyCrew("나 더 귀여워 져따 >.< 뿌잉뿡뿡쀼찍(?)");
  }

  @Override
  public void subscribe(Crew crew) {
    crews.add(crew);
  }

  @Override
  public void unsubscribe(Crew crew) {
    crews.remove(crew);
  }

  @Override
  public void notifyCrew(String msg) {
    crews.forEach(crew -> crew.update(msg));
  }
}