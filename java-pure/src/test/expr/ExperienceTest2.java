package test.expr;

import static java.lang.System.out;

import java.util.ArrayList;

public class ExperienceTest2 {

    public static void main(String[] args) {
        final ArrayList<Data> dataList = new ArrayList<>();
        dataList.add(new Data("a"));
        dataList.add(new Data("b"));
        dataList.add(new Data("c"));
        dataList.add(new Data("d"));

        internalMethod(dataList);

        out.println("after call this method");
        for (final Data data : dataList) {
            out.println("data = " + data);
        }
    }

    private static void internalMethod(final ArrayList<Data> dataList) {
        for (final Data data : dataList) {
            final String val = data.getVal();
            data.setVal("-" + val + "-");
        }
    }

    private static class Data {
        private String val = "0";

        public Data(final String val) {
            this.val = val;
        }

        public String getVal() {
            return val;
        }

        public void setVal(final String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "val='" + val + '\'' +
                    '}';
        }
    }
}
