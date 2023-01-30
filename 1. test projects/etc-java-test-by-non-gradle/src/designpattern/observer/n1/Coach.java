package designpattern.observer.n1;

public interface Coach {

  void subscribe(Crew crew);

  void unsubscribe(Crew crew);

  void notifyCrew(String msg);

}
