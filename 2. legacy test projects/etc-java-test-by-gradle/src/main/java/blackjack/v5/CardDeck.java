package blackjack.v5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class CardDeck {

    private List<Card> cards = new ArrayList<>();

    public CardDeck() {
        Suit[] suits = Suit.values();

        addAllCards(suits);
    }

    private void addAllCards(Suit[] suits) {
        for (Denomination denomination : Denomination.values()) {
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

    public int getScoreTotal() {
        return cards.stream()
                .mapToInt(Card::getScore)
                .sum();
    }
}
