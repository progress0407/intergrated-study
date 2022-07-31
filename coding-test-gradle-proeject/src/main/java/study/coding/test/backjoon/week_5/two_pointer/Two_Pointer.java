package study.coding.test.backjoon.week_5.two_pointer;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

class Two_Pointer {

    public static void main(String[] args) {
        int[] arr = {2, 3, 9, 13, 22};
        int N = 6;
        List<Pair> pairs = new ArrayList<>();

        for (int st = 0; st < 5; st++) {
            for (int en = st; en < 5; en++) {
                int diff = arr[en] - arr[st];
                if (diff > N) {
                    pairs.add(new Pair(arr[st], arr[en]));
                }
            }
        }

        for (final Pair pair : pairs) {
            out.println("pair = " + pair);
        }
    }

    static class Pair {
        int st;
        int en;

        public Pair(final int st, final int en) {
            this.st = st;
            this.en = en;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "st=" + st +
                    ", en=" + en +
                    '}';
        }
    }
}
