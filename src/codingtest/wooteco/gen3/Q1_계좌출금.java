package codingtest.wooteco.gen3;

import java.util.Arrays;

import static java.lang.System.out;

public class Q1_계좌출금 {
    /**
     * 50000, 10000, 5000, 1000, 500, 100
     * @param args
     */
    public static void main(String[] args) {
        int[] coin = {50000, 10000, 5000, 1000, 500, 100};
        int[] cnt = new int[coin.length];
//        int money = 933700;
        int money = 15000;
        for (int i = 0; i < coin.length; i++) {
            cnt[i] = money / coin[i];
            money %= coin[i];

        }

        out.println("Arrays.toString(cnt) = " + Arrays.toString(cnt));
    }
}
