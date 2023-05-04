package designpattern.strategy.n2;

public class Client {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Train train = new Train();

        bus.move();
        train.move();
    }
}
