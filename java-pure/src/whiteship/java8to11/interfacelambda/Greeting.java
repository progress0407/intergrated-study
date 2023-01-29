package whiteship.java8to11.interfacelambda;

public class Greeting {

    private String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }

    public String hello(String name) {
        return "hello ~ " + name;
    }
}
