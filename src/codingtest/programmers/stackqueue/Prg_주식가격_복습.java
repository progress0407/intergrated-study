package codingtest.programmers.stackqueue;

import java.util.Arrays;

import static java.lang.System.out;

public class Prg_주식가격_복습 {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] input = {1, 2, 3, 2, 3};
        // 4 3 1 1 0
//        int[] input = {3, 4, 1, 5, 2};
        // 1 1 2 1 0

        sol.solution(input);
    }

    static class Solution {
        public int[] solution(int[] input) {

            Price[] priceArr = new Price[input.length];
            for (int i = 0; i < input.length; i++) {
//                int maintain = i != input.length ? 1 : 0;
                priceArr[i] = new Price(input[i], 0);
            }

            Prices prices = new Prices(priceArr);

            prices.calc();

            for (Price price : prices.prices) {
                out.println(price);
            }

            int[] results = Arrays.stream(prices.prices).mapToInt(e -> e.maintain).toArray();

            out.println("Arrays.toString(results) = " + Arrays.toString(results));

            return results;
        }

        static class Prices {
            Price[] prices;

            public Prices(Price[] prices) {
                this.prices = prices;
            }

            public void calc() {
                for (int i = 0; i < prices.length - 1; i++) {
                    for (int j = i + 1; j < prices.length; j++) {
                        if (prices[i].val <= prices[j].val) {
                            prices[i].maintain++;
                        } else {
                            prices[i].maintain++;
                            break;
                        }
                    }
                }
            }
        }


        static class Price {
            int val;
            int maintain;

            public Price(int val, int maintain) {
                this.val = val;
                this.maintain = maintain;
            }

            @Override
            public String toString() {
                return "Price{" +
                        "val=" + val +
                        ", maintain=" + maintain +
                        '}';
            }
        }

    }
}
