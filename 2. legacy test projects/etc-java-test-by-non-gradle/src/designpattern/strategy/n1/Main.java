package designpattern.strategy.n1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Strategy Pattern");

        // Up
        Car car1 = new Car(new UpBehavior());
        car1.move();

        Car car2 = new Car(new DownBehavior());
        car2.move();

        Car car3 = new Car(new LeftBehavior());
        car3.move();

        Car car4 = new Car(new RightBehavior());
        car4.move();

    }
}
