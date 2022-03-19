package blackjack.statepattern;

import java.util.ArrayDeque;
import java.util.Queue;

class Deck {

    private Queue<Card> cards = new ArrayDeque<>();

    public Deck(Queue<Card> cards) {
        this.cards = cards;
    }

    public Card drawCard() {
        return cards.poll();
    }
}
