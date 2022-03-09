package blackjack.v3;

import java.util.Objects;

class Card {

    private DenominationInterface denominationInterface;
    private final Suit suit;

    public Card(DenominationInterface denominationInterface, Suit suit) {
        this.denominationInterface = denominationInterface;
        this.suit = suit;
    }

    public boolean isSameDenomination(DenominationInterface denominationInterface) {
        return this.denominationInterface.equals(denominationInterface);
    }

    public boolean isSameSuit(Suit suit) {
        return this.suit == suit;
    }

    public void chooseAceScoreAs1() {
        denominationInterface.chooseAceScoreAs1();
    }

    public void chooseAceValueAs11() {
        denominationInterface.chooseAceValueAs11();
    }

    public int getScore() {
        return denominationInterface.getScore();
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
        return denominationInterface.equals(card.denominationInterface) && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denominationInterface, suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "denomination=" + denominationInterface +
                ", suit=" + suit +
                '}';
    }
}
