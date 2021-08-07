package designpattern.strategy.n1;

public class Car {
    private CarMoveBehavior carMoveBehavior;

    public Car(CarMoveBehavior carMoveBehavior) {
        this.carMoveBehavior = carMoveBehavior;
    }

    public void setCarMoveBehavior(CarMoveBehavior carMoveBehavior) {
        this.carMoveBehavior = carMoveBehavior;
    }

    public void move() {
        carMoveBehavior.action();
    }
}
