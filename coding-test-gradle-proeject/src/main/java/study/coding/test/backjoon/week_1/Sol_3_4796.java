package study.coding.test.backjoon.week_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import static java.lang.System.out;

class Sol_3_4796 {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        ArrayList<String> answer = solve(reader);
        answer.forEach(out::println);
    }

    static ArrayList<String> solve(Reader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        String firstInput;
        ArrayList<String> 가능한_최대_여행일_리스트 = new ArrayList<>();

        int cnt = 1;
        while (true) {
            firstInput = br.readLine();
            if (firstInput.equals("0 0 0")) {
                break;
            }
            String[] inputArr = firstInput.split(" ");

            int L = Integer.parseInt(inputArr[0]);
            int P = Integer.parseInt(inputArr[1]);
            int V = Integer.parseInt(inputArr[2]);

            int 몫 = V / P;
            int 나머지 = V % P;

            int 가능한_휴가수 = 몫 * L;

            int 더_작은_수;
            if (나머지 < L) {
                더_작은_수 = 나머지;
            } else {
                더_작은_수 = L;
            }

            가능한_휴가수 += 더_작은_수;

            가능한_최대_여행일_리스트.add(String.format("Case %d: %s", cnt++, 가능한_휴가수));
        }

        return 가능한_최대_여행일_리스트;
    }
}
