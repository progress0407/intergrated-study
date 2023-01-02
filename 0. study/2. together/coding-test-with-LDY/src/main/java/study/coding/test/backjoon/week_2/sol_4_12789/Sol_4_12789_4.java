package study.coding.test.backjoon.week_2.sol_4_12789;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Stack;

/**
 *
 * ver3에서
 *   배열 기반으로 변경
 *     예를들어 [8, 4, 3, 2, 6] 라면... 순서에 맞추어서 정렬을 우선한다음에...
 *     [2, 3, 4, 6, 8] 여기서... 시작한다 !
 *
 */
class Sol_4_12789_4 extends Sol_4_12789 {

    static int person_size;
    static Integer[] waitingLine;
    static Stack<Integer> shelter;

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        Sol_4_12789_4 main = new Sol_4_12789_4();
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
    private void init(BufferedReader br) {
        person_size = Integer.parseInt(read(br));
        waitingLine =  new Integer[person_size];
        shelter = new Stack<>();
    }

    private boolean isFirst(int currentOrder) {
        Integer firstWaiter = waitingLine[currentOrder];
        for (int i = currentOrder + 1; i < waitingLine.length; i++) {
            if (waitingLine[i] < firstWaiter) {
                return false;
            }
        }
        return true;
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
