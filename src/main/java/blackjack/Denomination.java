package blackjack;

public enum Denomination {
    ACE("A", 0),
    TWO("2", 2),
    NINE("9", 9),
    JACK("10", 10),
    QUEEN("10", 10),
    KING("10", 10);

    private final String name;
    private final int value;

    Denomination(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
