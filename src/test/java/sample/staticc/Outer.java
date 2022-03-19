package sample.staticc;

class Outer {

    public int outVar = 0;

    static class Inner {
        public int innerVar = 0;

        @Override
        public String toString() {
            return "Inner{" +
                    "innerVar=" + innerVar +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Outer{" +
                "outVar=" + outVar +
                '}';
    }
}
