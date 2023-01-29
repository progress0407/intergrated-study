package blackjack.statepattern.utils;

import blackjack.statepattern.Card;
import blackjack.statepattern.MockDeck;
import java.util.Arrays;

public class CreationUtils {

    public static MockDeck createMockDeck(int... scores) {

        Card[] cards = Arrays.stream(scores)
                .boxed()
                .map(score -> new Card(score))
                .toArray(Card[]::new);

        return new MockDeck(cards);
    }
}
