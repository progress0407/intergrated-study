package test.grammer.collectionzz;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class ArrMain {
    public static void main(String[] args) {

//        printArr();
//        comp(); // new Decending()
//        comp2(); // new CustomDictionarySort()
//        comp3(); // new Ascending()

        addStr();

    }

    private static void addStr() {
        int[] arr1 = {0, 1, 0};
        String s = IntStream.of(arr1).mapToObj(String::valueOf).reduce((a, b) -> a + b).orElseGet(() -> "");
        out.println("s = " + s);
    }

    private static void comp3() {
        String[] simpleStr = {"a", "b", "c"};

        out.println("Arrays.toString(simpleStr) = " + Arrays.toString(simpleStr));
        Arrays.sort(simpleStr, new Ascending());
        out.println("Arrays.toString(simpleStr) = " + Arrays.toString(simpleStr));

    }

    private static void comp2() {

        Integer[] intArr = {120, 45, 60, 446, 386, 9}; // 순서는 이렇게 나와야 함 -> 9 60 45 446 386 120

        Arrays.sort(intArr);
        out.println("Arrays.toString(intArr) = " + Arrays.toString(intArr));

        Arrays.sort(intArr, Collections.reverseOrder());
        out.println("Arrays.toString(intArr) = " + Arrays.toString(intArr));

        Arrays.sort(intArr, new CustomDictionarySort());
        out.println("Arrays.toString(intArr) = " + Arrays.toString(intArr));

//        Arrays.sort(intArr, (o1, o2) -> 1);
//        out.println("Arrays.toString(intArr) = " + Arrays.toString(intArr));
//
//        Arrays.sort(intArr, (o1, o2) -> -1);
//        out.println("Arrays.toString(intArr) = " + Arrays.toString(intArr));
    }

    private static class CustomDictionarySort implements Comparator<Integer> {

        // 양수면 내림차순
        // 음수면 오름차순
        @Override
        public int compare(Integer o1, Integer o2) { // Integer는 Comparable을 상속받았기 때문에 형변환 필요 X

            char[] a = String.valueOf(o1).toCharArray();
            char[] b = String.valueOf(o2).toCharArray();

            int max = Math.min(a.length, b.length);

            for (int i = 0; i < max; i++) {
                if (a[i] > b[i]) return -1; // 큰것을 기준으로 오름차순 한다
                else if (a[i] < b[i]) return 1;
                // 같은 경우는 판별이 안나기 때문에 다음 것을 본다
            }

            return 0;
        }
    }

    private static void comp() {
        String[ ] strArr = {"cat", "Dog", "lion ", "tiger "} ;

        Arrays.sort(strArr);
        out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

        Arrays.sort(strArr, Collections.reverseOrder());
        out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));

        Arrays.sort(strArr, new Decending());
        out.println("Arrays.toString(strArr) = " + Arrays.toString(strArr));


    }

    private static class Ascending implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int i1 = o1.toCharArray()[0];
            int i2 = o2.toCharArray()[0];
            if (i1 > i2) {
                return 1;
            }
            return -1;
//            return o1.compareTo(o2);
        }
    }



    private static class Decending implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {

            if (o1 instanceof Comparable && o2 instanceof Comparable) {
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;
                return c1.compareTo(c2) * -1;
            }
            return -1;
        }
    }

    private static void printArr() {
        int[] oneDime = {11, 22, 33};
        int[][] twoDim =  {{1, 2, 3}, {4, 5, 6}};
        int[][][] threeDim = {{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}, {10, 11, 12}}};

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                out.printf("twoDim[%d][%d] = %d,  ", i, j, twoDim[i][j]);
            }
            out.println();
        }

        out.println("Arrays.toString(oneDime) = " + Arrays.toString(oneDime));
//        out.println("Arrays.deepToString(oneDime) = " + Arrays.deepToString(oneDime)); // Object[] 변환 에러 Integer[]는 가능하다

        out.println("Arrays.deepToString(twoDim) = " + Arrays.deepToString(twoDim));
//        out.println("Arrays.toString(twoDim) = " + Arrays.toString(twoDim)); // 의미 없는 주소 출력

        out.println("Arrays.deepToString(threeDim) = " + Arrays.deepToString(threeDim));
    }
}
