package whiteship.java8to11.interfacelambda;

@FunctionalInterface
public interface TriAdd <T, U, R, S> {
    S returnAdd(T t, U u, R r);
}
