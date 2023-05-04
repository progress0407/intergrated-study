package designpattern.strategy.n3;

import static java.lang.System.*;

public interface SearchStrategy {

  public void search();
}

class SearchStrategyAll implements SearchStrategy {

  @Override
  public void search() {
    out.println("SEARCH ALL");
  }
}

class SearchStrategyImage implements SearchStrategy {

  @Override
  public void search() {
    out.println("SEARCH IMAGE");
  }
}

class SearchStrategyNews implements SearchStrategy {

  @Override
  public void search() {
    out.println("SEARCH NEWS");
  }
}

class SearchStrategyMap implements SearchStrategy {

  @Override
  public void search() {
    out.println("SEARCH MAP");
  }
}

