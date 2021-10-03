package whiteship.java8to11.interfacelambda;

@FunctionalInterface
public interface 순서가_중요한지<T, U, R, S> {
    U returnAdd(T t, R r, S s);
}
