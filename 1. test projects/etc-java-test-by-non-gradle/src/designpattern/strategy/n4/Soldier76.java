package designpattern.strategy.n4;

public class Soldier76 implements Echo {

  @Override
  public void attack() {
    System.out.println("솔져76: 펄스소총 두두두둗루 !! 돼지고기 두루치기 마이쪙!");
  }

  @Override
  public OverwarchHeros getSymbol() {
    return OverwarchHeros.H01;
  }
}
