package codingtest.nadongbin.lec2greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import static java.lang.System.out;

public class Q5_문자열뒤집기 {
    public static void main(String[] args) throws IOException {

        /**
         * 0001100
         * 11111
         * 00000001
         * 11001100110011000001
         * 11101101
         *
         * 여니 방식으로 다시 접근해보자
         *
         * 두 배열을 각자 1 / 0으로 만든후 누구의 max가 큰지를 비교
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String inputStr = st.nextToken();

        char[] chars = inputStr.toCharArray();

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i] - '0');
        }

        int start = 0;
        int end = 0;
        int cnt = 0;


        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                start = i + 1;
                end = start;
                cnt++;


                while (end + 1 != chars.length // 마지막 인덱스 접근시
                        && chars[end] == chars[end + 1]) {
                    end++;
                }

                for (int j = start; j <= end; j++) {
                    chars[j] = (char)('1' - chars[j] + '0');
                }

            }
        }

        out.println(cnt);

    }
}
