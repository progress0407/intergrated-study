package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private List<Card> cards = new ArrayList<>();

    public CardDeck() {
        Denomination[] denominations = Denomination.values();
        Suit[] suits = Suit.values();

        for (Denomination denomination : denominations) {
            for (Suit suit : suits) {
                cards.add(new Card(denomination, suit));
            }
        }
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
