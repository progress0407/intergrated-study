package blackjack.v3;

enum Denomination implements DenominationInterface {
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
    int score;

    Denomination(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.name(), score);
    }

    @Override
    public void chooseAceScoreAs1() {

    }

    @Override
    public void chooseAceValueAs11() {

    }
}
