package test.grammer.clazz;

public class OuterOfStatic {
    static class StaticNested {
        private int val = 0;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
