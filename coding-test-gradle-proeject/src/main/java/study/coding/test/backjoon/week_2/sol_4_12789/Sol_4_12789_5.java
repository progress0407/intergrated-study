package study.coding.test.backjoon.week_2.sol_4_12789;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 들어온 순서대로 작성
 */
class Sol_4_12789_5 extends Sol_4_12789 {

    private BufferedReader br;
    private int person_size;
    private LinkedList<Integer> waitingLine;
    private Stack<Integer> shelter;
    private Integer[] orderList;
    private int currentOrderIndex;


    public static void main(String[] args) {
        final Sol_4_12789_5 sol_4_12789_5 = new Sol_4_12789_5();
        InputStreamReader reader = new InputStreamReader(System.in);
        String output = sol_4_12789_5.solve(reader);

        out.println("output = " + output);
    }

    public String solve(final Reader reader) {
        br = new BufferedReader(reader);
        init();
        while (!waitingLine.isEmpty()) {
            while (!shelter.isEmpty()) {
                final Integer firstShelter = shelter.peek();
                if (firstShelter.equals(orderList[currentOrderIndex])) {
                    shelter.pop();
                    currentOrderIndex++;
                } else {
                    break;
                }
            }
            final Integer firstWaiter = waitingLine.poll();
            if (firstWaiter.equals(orderList[currentOrderIndex])) {
                currentOrderIndex++;
            } else {
                shelter.push(firstWaiter);
            }
        }
        return irOrder() ? "Nice" : "Sad";
    }

    private boolean irOrder() {
        if (shelter.isEmpty()) {
            return true;
        }
        int first = shelter.pop();
        int second;
        while (!shelter.isEmpty()) {
            second = shelter.pop();
            if (first > second) {
                return false;
            }
            first = second;
        }
        return true;
    }

    private void init() {
        currentOrderIndex = 0;
        person_size = parseInt(read());
        waitingLine = new LinkedList<>();
        shelter = new Stack<>();
        orderList = new Integer[person_size];

        final String[] inputs = read().split(" ");
        for (int i = 0; i < inputs.length; i++) {
            final int num = parseInt(inputs[i]);
            waitingLine.add(num);
            orderList[i] = num;
        }
        Arrays.sort(orderList);
    }

    private String read() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
