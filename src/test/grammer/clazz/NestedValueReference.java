package test.grammer.clazz;

public class NestedValueReference {

    int a;
    static int b;

    static class StaticNested {
        public void setVal() {
//            a = 3; // error
            b = 3;
        }
    }

    class InnerNested {
        public void setVal() {
            a = 3;
            b = 3;
        }
    }
}
