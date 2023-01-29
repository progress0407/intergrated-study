package blackjack.v5;

enum Denomination {
    ACE("A", 1, 11),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    JACK("10", 10),
    QUEEN("10", 10),
    KING("10", 10);

    private final String name;
    int[] score;

    Denomination(String name, int... score) {
        this.name = name;
        this.score = score;
    }

    public static boolean isAce(String denominationName) {
        return ACE.name.equals(denominationName);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score[0];
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.name(), score);
    }
}
