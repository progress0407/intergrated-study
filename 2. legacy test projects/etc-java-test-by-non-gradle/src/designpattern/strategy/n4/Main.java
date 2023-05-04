package designpattern.strategy.n4;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
//    Echo echo = new Soldier76();
    List<Echo> echos
        = new ArrayList<>(Arrays.asList(new Soldier76(), new Reinhardt(), new Tracer()));

    for (Echo echo : echos) {
      switch (echo.getSymbol()) {
        case H01:
          out.print("첫 번째 영웅 : ");
          break;
        case H02:
          out.print("두 번째 영웅 : ");
          break;
        case H03:
          out.print("세 번째 영웅 : ");
          break;
      }
      out.println(echo.getSymbol().getName());
      echo.attack();
      out.println(); // just LF
    }
  }
}
