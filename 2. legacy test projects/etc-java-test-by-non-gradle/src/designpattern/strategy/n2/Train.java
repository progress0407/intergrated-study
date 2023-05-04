package designpattern.strategy.n2;

public class Train implements Movable {
    @Override
    public void move() {
        System.out.println("im the Train >< moving");
    }
}
