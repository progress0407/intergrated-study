package simple.generic;

public class GenericTest<T> {
    public static void main(String[] args) {
        Id<A> aId = new Id<>();
        Id<B> bId = new Id<>();
//        aId.isSameId(bId); // compile error !
    }
}
