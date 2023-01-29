package blackjack.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class CardDeck {

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
        return cards;
    }

    public List<Card> findByDenomination(Denomination denomination) {
        return cards.stream()
                .filter(card -> card.isSameDenomination(denomination))
                .collect(Collectors.toList());
    }

    public List<Card> findBySuit(Suit suit) {
        return cards.stream()
                .filter(card -> card.isSameSuit(suit))
                .collect(Collectors.toList());
    }
}
