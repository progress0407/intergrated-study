package study.coding.test.backjoon.week_2.sol_4_12789;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Fail : 63% 에서 틀렸습니다...
 * ver2에서
 *   Shelter: List -> Array 로 변경
 *
 *   틀린 이유?
 *     // 쉼터 첫 사람이 빵 받을 순서보다 더 우선순위라면
 *     이 부분에서.. 셸터 첫 사람이 정말 우선순위에 있다는 것을 보장할 수 없다 !
 */
class Sol_4_12789_3 extends Sol_4_12789 {

    static int person_size;
    static Integer[] waitingLine;
    static Stack<Integer> shelter;

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        Sol_4_12789_3 main = new Sol_4_12789_3();
        String output = main.solve(reader);
        out.println(output);
    }

    public String solve(Reader reader) {
        BufferedReader br = new BufferedReader(reader);

        init(br);

        String[] inputs = read(br).split(" ");

        for (int i = 0; i < person_size; i++) {
            waitingLine[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 0; i < waitingLine.length; i++) {
            Integer firstWaiter = waitingLine[i];
            // 빵 받을 순서라면
            if (isFirst(i)) {
                // 그런데 쉼터에 사람이 있다면
                while (!shelter.isEmpty()) {
                    Integer firstShelter = shelter.peek();
                    // 쉼터 첫 사람이 빵 받을 순서보다 더 우선순위라면
                    if (firstShelter < firstWaiter) {
                        shelter.pop();
                    } else {
                        break;
                    }
                }
            }
            // 빵 받을 순서가 아니라면
            else {
                shelter.push(firstWaiter);
            }
        }

        return isShelterOrdered() ? "Nice" : "Sad";
    }

    // 빵 받을 순서에요?
    private boolean isFirst(int currentOrder) {
        Integer firstWaiter = waitingLine[currentOrder];
        for (int i = currentOrder + 1; i < waitingLine.length; i++) {
            if (waitingLine[i] < firstWaiter) {
                return false;
            }
        }
        return true;
    }

    private void init(BufferedReader br) {
        person_size = Integer.parseInt(read(br));
        waitingLine =  new Integer[person_size];
        shelter = new Stack<>();
    }

    private boolean isShelterOrdered() {
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
