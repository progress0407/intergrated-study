package designpattern.strategy.n4;

public class Reinhardt implements Echo {

  @Override
  public void attack() {
    System.out.println("라인하르트: 로캣해머 수우웅ㅇ");
  }

  @Override
  public OverwarchHeros getSymbol() {
    return OverwarchHeros.H02;
  }
}
