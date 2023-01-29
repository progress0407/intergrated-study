package test.expr;

import static java.lang.System.out;

import java.util.Arrays;

public class ExperienceTest3 {

    public static void main(String[] args) {
        final Data[] dataArr = new Data[4];
        final Data data = new Data("data");
        dataArr[0] = data;
        dataArr[1] = data;
        dataArr[2] = data;
        dataArr[3] = data;

        internalMethod(dataArr);

        out.println("after call this method");

        for (final Data data1 : dataArr) {
            out.println("data1 = " + data1);
        }
    }

    private static void internalMethod(final Data[] dataArr) {
        for (int i = 0; i < dataArr.length; i++) {
            final Data data = dataArr[i];
            final String val = data.getVal();
            final String newVal = "-" + val + "-";
            data.setVal(newVal);
        }
        out.println("Arrays.toString(dataArr) = " + Arrays.toString(dataArr));
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
