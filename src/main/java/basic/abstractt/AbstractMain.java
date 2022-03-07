package basic.abstractt;

import basic.abstractt.AbstractMain.AInterface;
import basic.abstractt.AbstractMain.BInterface;

public class AbstractMain {

    public static void main(final String... args) {
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.methodA();
        concreteClass.methodB();
        concreteClass.commonMethod();
    }

    private static class ConcreteClass implements AInterface, BInterface {

        @Override
        public void commonMethod() {
            AInterface.super.commonMethod();
        }
    }

    interface AInterface {
        default void methodA() {
            System.out.println("aa");
        }

        default void commonMethod() {
            System.out.println("common");
        }
    }

    interface BInterface {
        default void methodB() {
            System.out.println("bb");
        }

        default void commonMethod() {
            System.out.println("common");
        }
    }
}
