package codingtest.nadongbin.greedy;

import java.util.*;

import static java.lang.System.out;

public class Q1_거스름돈 {

    public static void main(String[] args) {

        LinkedHashMap<Integer, Integer> coin = new LinkedHashMap<>();

        coin.put(500, 0);
        coin.put(100, 0);
        coin.put(50, 0);
        coin.put(10, 0);

        int INPUT_MONEY = 1260;
        int count = 0;

        while(INPUT_MONEY != 0) {
            if(INPUT_MONEY >= coin.get(500)) {
                int quotient = INPUT_MONEY / 500;
                count += quotient;
                INPUT_MONEY %= 500; // 나머지
                coin.replace(500, coin.get(500) + quotient);
            }
            if (INPUT_MONEY >= coin.get(100)) {
                int quotient = INPUT_MONEY / 100;
                count += INPUT_MONEY / 100;
                INPUT_MONEY %= 100;
                coin.replace(100, coin.get(100) + quotient);
            }
            if (INPUT_MONEY >= coin.get(50)) {
                int quotient = INPUT_MONEY / 50;
                count += INPUT_MONEY / 50;
                INPUT_MONEY %= 50;
                coin.replace(50, coin.get(50) + 1);
            }
            if (INPUT_MONEY >= coin.get(10)) {
                int quotient = INPUT_MONEY / 10;
                count += INPUT_MONEY / 10;
                INPUT_MONEY %= 10;
                coin.replace(10, coin.get(10) + 1);
            }
        }

        out.printf("count = %d, INPUT_MONEY = %d \n",count, INPUT_MONEY);
        coin.forEach((k, v) -> out.printf("coin[%d, %d] \n", k, v));

    }

}
