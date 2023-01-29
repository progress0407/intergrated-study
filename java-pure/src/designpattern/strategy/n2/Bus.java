package designpattern.strategy.n2;

public class Bus implements Movable {
    @Override
    public void move() {
        System.out.println("im the Bus >< moving");
    }
}
