package blackjack.v5;

import java.util.Objects;

class Card {

    private String denominationName;
    private int score;
    private final Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denominationName = denomination.getName();
        this.suit = suit;
    }

    public boolean isSameDenomination(Denomination denomination) {
        return this.denominationName.equals(denomination.getName());
    }

    public boolean isSameSuit(Suit suit) {
        return this.suit == suit;
    }

    public void chooseAceScoreAs1() {
        if (Denomination.isAce(denominationName)) {
            score = 1;
        }
    }

    public void chooseAceValueAs11() {
        if (Denomination.isAce(denominationName)) {
            score = 11;
        }
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return score == card.score && Objects.equals(denominationName, card.denominationName)
                && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denominationName, score, suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "denominationName='" + denominationName + '\'' +
                ", score=" + score +
                ", suit=" + suit +
                '}';
    }
}
