package codingtest.nadongbin.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.out;

/**
 * 만드는데 굉장히 오래 걸려 다시 Re Try를 해본다
 */
public class Q5_문자열뒤집기_ReTry {
    public static void main(String[] args) throws IOException {

//        resolve();
        resolve2();
    }

    private static void resolve2() { // 여니 풀이

        /**
         * 0001100
         * 11111
         * 00000001
         * 11001100110011000001
         * 11101101
         *
         * 여니 방식으로 다시 접근해보자
         * 두 배열을 각자 1 / 0으로 만든후 누구의 max가 큰지를 비교
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inStr = st.nextToken();

        // 깊은 복사
        char[] toOnes = inStr.toCharArray();
        char[] toZeros = inStr.toCharArray();

        int cntToOnes = 0;
        for (int i = 0; i < toOnes.length - 1; i++) {
            if (toOnes[i] != '1') {
                while (i < toOnes.length && toOnes[i] != '1') {
                    toOnes[i] = '1';
                    i++;
                }
                cntToOnes++;
            }
        }

        int cntToZeros = 0;
        for (int i = 0; i < toZeros.length; i++) {
            if (toZeros[i] != '0') {
                while (i < toZeros.length && toZeros[i] != '0') {
                    toZeros[i] = '0';
                    i++;
                }
                cntToZeros++;
            }
        }

        int min = Math.min(cntToZeros, cntToOnes);

//        out.println("cntToZeros = " + cntToZeros);
//        out.println("cntToOnes = " + cntToOnes);
//        out.println("min = " + min);
        out.println(min);

    }

    private static void resolve() { // 다시 구현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        try {
            st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inStr = st.nextToken();

        char[] chs = inStr.toCharArray();

        int cnt = 0;
        for (int i = 0; i < chs.length - 1; i++) {

            int start = 0;
            int end = 0;

            if (chs[i] != chs[i + 1]) {
                cnt++;
                start = i + 1;
                end = start;
                while (end + 1 < chs.length && chs[end] == chs[end + 1]) end++;

                for (int j = start; j <= end; j++) {
                    chs[j] = (char) ('1' - chs[j] + '0');
                }
            }
        }

//        out.println("Arrays.toString(chrs) = " + Arrays.toString(chs));

//        out.println("cnt = " + cnt);
        out.println(cnt);
    }
}
