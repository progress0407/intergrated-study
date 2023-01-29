package test.grammer.clazz;

public class OuterOfInner {

    class Inner {
        int val = 0;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        Inner inner = new Inner(); // error
//        OuterOfInner outer = new OuterOfInner();
//        Inner inner = outer.new Inner();
        Inner inner = new OuterOfInner().new Inner();
        inner.setVal(30);
        System.out.println("inner.getVal() = " + inner.getVal());
    }
}
