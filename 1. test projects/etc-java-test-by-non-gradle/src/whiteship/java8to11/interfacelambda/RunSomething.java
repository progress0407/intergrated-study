package whiteship.java8to11.interfacelambda;

@FunctionalInterface
public interface RunSomething {

    int doIt(int number);

    static void printName() {
        System.out.println("성우");
    }

    default void printCode() {
        System.out.println("swcho");
    }

}
