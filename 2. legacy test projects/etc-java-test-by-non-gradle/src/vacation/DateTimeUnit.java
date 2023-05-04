package vacation;

public enum DateTimeUnit {

      SEC(1)
    , MINUTE(60)
    , HOUR(60 * 60)
    , HALF_DAY(8 * 60 * 60 / 2)
    , DAY(8 * 60 * 60);

    final int second;

    public int getSecond() {
        return second;
    }

    DateTimeUnit(int second) {
        this.second = second;
    }
}
