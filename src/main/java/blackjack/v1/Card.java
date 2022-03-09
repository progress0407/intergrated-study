package blackjack.v1;

import java.util.Objects;

class Card {

    private final Denomination denomination;
    private final Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public boolean isSameDenomination(Denomination denomination) {
        return this.denomination == denomination;
    }

    public boolean isSameSuit(Suit suit) {
        return this.suit == suit;
    }

    public void chooseAceScoreAs1() {
        denomination.chooseAceScoreAs1();
    }

    public void chooseAceValueAs11() {
        denomination.chooseAceValueAs11();
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
        return denomination == card.denomination && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "denomination=" + denomination +
                ", suit=" + suit +
                '}';
    }
}
