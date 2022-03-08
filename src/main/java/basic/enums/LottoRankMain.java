package basic.enums;

public class LottoRankMain {

    public static void main(final String... args) {
        System.out.println("FIRST = " + LottoRank.FIRST.match(6, true));
        System.out.println("SECOND = " + LottoRank.SECOND.match(5, true));
        System.out.println("THIRD = " + LottoRank.THIRD.match(4, false));
        System.out.println("THIRD = " + LottoRank.THIRD.match(4, true));
    }

    private enum LottoRank {
        FIRST(1_000_000, 6) ,
        SECOND(500_000, 5) {
            @Override
            public boolean match(int hitCount, boolean hitBonus) {
                return hitCount == 5 & hitBonus;
            }
        },
        THIRD(300_000, 4) {
            @Override
            public boolean match(int hitCount, boolean hitBonus) {
                return hitCount == 4 & !hitBonus;
            }
        };

        private final int money;
        private final int hitCount;

        LottoRank(int money, int hitCount) {
            this.money = money;
            this.hitCount = hitCount;
        }

        public boolean match(int hitCount, boolean hitBonus) {
            return this.hitCount == hitCount;
        }
    }
}
