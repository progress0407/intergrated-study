package designpattern.strategy.n4;

public class Tracer implements Echo {

  @Override
  public void attack() {
    System.out.println("트레이서: 펄스 쌍권총 피퓨부부부");
  }

  @Override
  public OverwarchHeros getSymbol() {
    return OverwarchHeros.H03;
  }
}
