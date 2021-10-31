package codingtest.nadongbin.dp;

import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.System.out;

public class Q5_병사_배치하기 {
    public static void main(String[] args) {

        solve1();

    }

    private static void solve1() {

        int[] arr = {15, 11, 4, 8, 5, 2, 4};

        LinkedList<Integer> list = new LinkedList<>();

        for (int e : arr) {
            list.add(e);
        }

        out.println("list = " + list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                list.remove(i);
            }
        }

        out.println("list = " + list);
    }
}
