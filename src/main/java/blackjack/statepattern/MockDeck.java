package blackjack.statepattern;

import java.util.ArrayDeque;
import java.util.List;

class MockDeck extends Deck{

    public MockDeck(Card... cards) {
        super(new ArrayDeque<>(List.of(cards)));
    }
}
