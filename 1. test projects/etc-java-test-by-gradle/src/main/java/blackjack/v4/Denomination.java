package blackjack.v4;

import java.util.Objects;

abstract class Denomination {
    public static final Denomination TWO = new Denomination("2", 2) {
    };
    public static final Denomination THREE = new Denomination("3", 3) {
    };
    public static final Denomination FOUR = new Denomination("4", 4) {
    };
    public static final Denomination FIVE = new Denomination("5", 5) {
    };
    public static final Denomination SIX = new Denomination("6", 6) {
    };
    public static final Denomination SEVEN = new Denomination("7", 7) {
    };
    public static final Denomination EIGHT = new Denomination("8", 8) {
    };
    public static final Denomination NINE = new Denomination("9", 9) {
    };
    public static final Denomination JACK = new Denomination("10", 10) {
    };
    public static final Denomination QUEEN = new Denomination("10", 10) {
    };
    public static final Denomination KING = new Denomination("10", 10) {
    };

    protected final String name;
    protected int score;

    Denomination(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public static Denomination[] values() {
        return new Denomination[]{
            TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, JACK, QUEEN, KING
        };
    }

    public void chooseAceScoreAs1() {

    }

    public void chooseAceValueAs11() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Denomination that = (Denomination) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Denomination{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
