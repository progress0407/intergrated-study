package test.grammer.clazz;

public class NestedClassMain {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
        Anonymouzz anonymouzz = new Anonymouzz();
        anonymouzz.setListener(new EventListener() {
            @Override
            public void onClick() {
                System.out.println("Anonymous Button Click !! ");
            }
        });
//        anonymouzz.setListener(() -> System.out.println("Anonymous Button Click !! "));
        anonymouzz.onClickProcess();
    }


    private static void test2() { // inner
        OuterOfInner outer = new OuterOfInner();
        OuterOfInner.Inner inner = outer.new Inner();
        inner.setVal(25);
        System.out.println("inner.getVal() = " + inner.getVal());
    }

    private static void test1() { // static
        OuterOfStatic.StaticNested os = new OuterOfStatic.StaticNested();
        os.setVal(35);
        System.out.println("os.getVal() = " + os.getVal());
    }

}
