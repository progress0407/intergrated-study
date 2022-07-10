package study.coding.test.backjoon.week_2.sol_4_12789;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ver1에 비해 로직 변경
 *
 * 3% 진행후 간 초과 !
 */
class Sol_4_12789_2 extends Sol_4_12789 {

    static int person_size;
    static LinkedList<Integer> waitingLine;
    static Stack<Integer> shelter;

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        Sol_4_12789_2 main = new Sol_4_12789_2();
        String output = main.solve(reader);
        out.println(output);
    }

    public String solve(Reader reader) {
        BufferedReader br = new BufferedReader(reader);
        init(br);

        String[] inputs = read(br).split(" ");

        for (int i = 0; i < person_size; i++) {
            waitingLine.add(Integer.parseInt(inputs[i]));
        }

        while (!waitingLine.isEmpty()) {
            Integer firstWaiter = waitingLine.peek();
            // 빵 받을 순서라면
            if (isFirst()) {
                // 그런데 쉼터에 사람이 있다면
                if (!shelter.isEmpty()) {
                    Integer firstShelter = shelter.peek();
                    // 쉼터 첫 사람이 빵 받을 순서보다 더 우선순위라면
                    if (firstShelter < firstWaiter) {
                        shelter.pop();
                    } else {
                        waitingLine.poll();
                    }
                } else {
                    waitingLine.poll();
                }
            }
            // 빵 받을 순서가 아니라면
            else {
                waitingLine.poll();
                shelter.push(firstWaiter);
            }
        }

        return isOrder() ? "Nice" : "Sad";
    }

    // 빵 받을 순서에요?
    private boolean isFirst() {
        Integer firstWaiter = waitingLine.peek();
        for (int i = 1; i < waitingLine.size(); i++) {
            if (waitingLine.get(i) < firstWaiter) {
                return false;
            }
        }
        return true;
    }

    private void init(BufferedReader br) {
        person_size = Integer.parseInt(read(br));
        waitingLine = new LinkedList<>();
        shelter = new Stack<>();
    }

    private boolean isOrder() {
        if (shelter.size() < 2) {
            return true;
        }
        Integer first = shelter.pop();
        while (!shelter.isEmpty()) {
            Integer second = shelter.pop();
            if (first > second) {
                return false;
            }
            first = second;
        }
        return true;
    }

    private String read(BufferedReader br) {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
