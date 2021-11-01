package codingtest.programmers.stackqueue;

import java.util.Arrays;

import static java.lang.System.out;

public class Prg_주식가격 {

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] input = {1, 2, 3, 2, 3};

         sol.solution(input);

    }

    static class Solution {

        public int[] solution(int[] input) {

            int length = input.length;
            Price[] priceArr = new Price[length];
            for (int i = 0; i < length; i++) {
                priceArr[i] = new Price(input[i]);
            }

            Prices prices = new Prices(priceArr);

            prices.print();
            prices.calc();
            prices.print();

            int[] result = Arrays.stream(prices.prices).map(e -> e.maintain).mapToInt(e -> e).toArray();

            return result;
        }

    }

    static class Price {
        int val;
        int maintain;

        public Price(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Price{" +
                    "val=" + val +
                    ", maintain=" + maintain +
                    '}';
        }
    }

    static class Prices {
        Price[] prices;

        public Prices(Price[] priceArr) {
            this.prices = priceArr;
        }

        public void print() {
            for (Price price : prices) {
                out.println("price = " + price);
            }
        }

        public void calc() {
            int length = prices.length;
            for (int i = 0; i < length - 1; i++) {
                Price price = prices[i];
                for (int j = i + 1; j < length; j++) {
                    price.maintain++;
                    if (price.val > prices[j].val) break;
                }
            }
        }
    }
}
