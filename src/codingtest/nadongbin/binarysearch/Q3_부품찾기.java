package codingtest.nadongbin.binarysearch;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Q3_부품찾기 {

    private static final int[] n = {8, 3, 7, 9, 2};
    private static final int[] m = {5, 7, 9};

    public static void main(String[] args) {

//        binarySearch();
//        binarySearch2();
        countingSort();
//        solveBySet();

    }



    private static void solveBySet() {
        Integer[] N = IntStream.of(n).boxed().toArray(Integer[]::new);
        Integer[] M = IntStream.of(m).boxed().toArray(Integer[]::new);
        Set<Integer> setN = new HashSet<>(Arrays.asList(N));
//        Arrays.stream(N).forEach(e -> setN.add(e));
        // setN.addAll(Arrays.asList(N));

        Set<Integer> setM = new HashSet<>(Arrays.asList(M));


        LinkedList<String> r = new LinkedList<>();
        for (Integer m : setM) {
            if (setN.contains(m)) {
                r.add("true");
                continue;
            }
            r.add("false");
        }

        r.stream().forEach(e -> out.print(e + " "));


    }

    private static void countingSort() {

        int nMax = 0;
        for (int i = 0; i < n.length; i++) if (n[i] > nMax) nMax = n[i];

        int mMax = 0;
        for (int i = 0; i < m.length; i++) if (m[i] > mMax) mMax = m[i];

        int max = Math.max(nMax, mMax);

        int[] counting = new int[max + 1];

        out.println("nMax = " + nMax);
        out.println("mMax = " + mMax);
        out.println("max = " + max);

        // 내 부품 기록
        for (int i = 0; i < n.length; i++) {
            counting[n[i]]++;
        }

        out.println("Arrays.toString(counting) = " + Arrays.toString(counting));

        ArrayList<String> result = new ArrayList<>();
        // 찾을 부품 색인
        for (int i = 0; i < m.length; i++) {
            if (counting[m[i]] == 1) {
                result.add("true");
                continue;
            }
            result.add("false");
        }

        result.forEach(e-> out.print(e + " "));

}

    private static void binarySearch2() {
        Integer[] N = IntStream.of(n).boxed().toArray(Integer[]::new);
        Arrays.sort(N, Comparator.reverseOrder());

        out.println("Arrays.toString(N) = " + Arrays.toString(N));

        String[] result = new String[m.length];

        for (int i = 0; i < m.length; i++) {

            int start = 0;
            int end = n.length - 1;
            int mid = 0;

            while (start <= end) {
                mid = (start + end) / 2;
                if(m[i] == n[mid]) {
                    result[i] = "true";
                    break;
                }
                else if (m[i] < n[mid]) end = mid - 1;
                else start = mid + 1;
            }
            if (m[i] != n[mid]) result[i] = "false";
        }

        Arrays.stream(result).forEach(e-> out.print(e + " "));

    }

    private static void binarySearch() {
        Arrays.sort(n);
        String[] result = new String[m.length];

        for (int i = 0; i < m.length; i++) {

            int start = 0;
            int end = n.length - 1;
            int mid = 0;

            while (start <= end) {
                mid = (start + end) / 2;
                if(m[i] == n[mid]) {
                    result[i] = "true";
                    break;
                }
                else if(m[i] < n[mid]) end = mid - 1;
                else start = mid + 1;
            }
            if(m[i] != n[mid]) result[i] = "false";
        }

        Stream.of(result).forEach(e -> out.print(e + " "));
    }
}
