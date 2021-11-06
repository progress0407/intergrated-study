package codingtest.wooteco.gen4;

import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Q3_ {
    public static void main(String[] args) {

        Solution sol = new Solution();


//        String[] ings = {"r 10", "a 23", "t 124", "k 9"};
//        String[] menu = {"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"};
//        String[] sell = {"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};

        String[] ings = {"x 25", "y 20", "z 1000"};
        String[] menu = {"AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"};
        String[] sell = {"BBBB 3", "TTT 2"};


        sol.solution(ings, menu, sell);

    }

    static class Solution {

        private static Map<Character, Integer> ings;
        private static List<Menu> menus;
        private static List<Sell> sells;

        public int solution(String[] ingsIn, String[] menuIn, String[] sellIn) {

            ings = getIngs(ingsIn);
            menus = getMenus(menuIn);
            sells = getSells(sellIn);

            int sum = sells.stream().mapToInt(e -> e.totalPriceForMenu).reduce(Integer::sum).getAsInt();

            return sum;
        }

        private List<Sell> getSells(String[] sellIn) {
            List<Sell> sells = new ArrayList<>();
            for (String s : sellIn) {
                Sell sell = new Sell(s);
                sell.calcTotalPriceForMenu();
                sells.add(sell);
            }
            return sells;
        }

        private List<Menu> getMenus(String[] menuIn) {
            List<Menu> menus = new ArrayList<>();

            for (String m : menuIn) {
                Menu menu = new Menu(m);
                menu.calcOriginPrice();
                menu.calcDiffPrice();
                menus.add(menu);
            }
            return menus;
        }

        private Map<Character, Integer> getIngs(String[] ingsIn) {
            ings = new HashMap();
            for (String i : ingsIn) {
                String[] s = i.split(" ");
                Character name = s[0].charAt(0);
                Integer price = Integer.valueOf(s[1]);
                ings.put(name, price);
            }
            return ings;
        }

        static class Menu {
            String name;
            char[] ingList;
            int price; // 판매가
            int originPrice; // 원가
            int diffPrice; // 순수익

            public Menu(String in) {
                String[] split = in.split(" ");
                this.name = split[0];
                this.ingList = split[1].toCharArray();
                Arrays.sort(ingList);
                this.price = Integer.parseInt(split[2]);
            }

            public void calcOriginPrice() {
                originPrice = 0;
                for (char i : ingList) {
                    originPrice += ings.get(i);
                }
            }

            public void calcDiffPrice() {
                diffPrice = price - originPrice;
            }

            @Override
            public String toString() {
                return "Menu{" +
                        "name='" + name + '\'' +
                        ", ingList=" + Arrays.toString(ingList) +
                        ", price=" + price +
                        ", originPrice=" + originPrice +
                        ", diffPrice=" + diffPrice +
                        '}';
            }
        }

        static class Sell {
            String name;
            int count; // 판매수량
            int totalPriceForMenu;

            public Sell(String in) {
                String[] split = in.split(" ");
                this.name = split[0];
                this.count = Integer.parseInt(split[1]);
            }

            public void calcTotalPriceForMenu() {
                Menu menu = menus.stream().filter(e -> e.name.equals(this.name)).findAny().get();
                totalPriceForMenu = menu.diffPrice * this.count;
            }

            @Override
            public String toString() {
                return "Sell{" +
                        "name='" + name + '\'' +
                        ", count=" + count +
                        ", totalPriceForMenu=" + totalPriceForMenu +
                        '}';
            }
        }
        

    }
}
