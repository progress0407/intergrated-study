package designpattern.strategy.n4;

public enum OverwarchHeros {
  H01("Soldier76"), H02("Reinhardt"), H03("Tracer");

  private String name;

  OverwarchHeros(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
