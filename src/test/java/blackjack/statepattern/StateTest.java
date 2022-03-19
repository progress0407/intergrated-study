package blackjack.statepattern;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;


class StateTest {

    @Test
    void READY에서_NORMAL() {
        Hand hand = new Hand();

        assertThat(hand.getState()).isInstanceOf(Ready.class);

        hand.receiveCards(new MockDeck(new Card(5), new Card(9)));

        assertThat(hand.getState()).isInstanceOf(Normal.class);
    }

    @Test
    void READY에서_BLACKJACK() {
        Hand hand = new Hand();

        assertThat(hand.getState()).isInstanceOf(Ready.class);

        hand.receiveCards(new MockDeck(new Card(11), new Card(10)));

        assertThat(hand.getState()).isInstanceOf(BlackJack.class);
    }

    @Test
    void NORMAL에서_NORMAL() {
        Hand hand = new Hand();

        assertThat(hand.getState()).isInstanceOf(Ready.class);

        hand.receiveCards(new MockDeck(new Card(2), new Card(3)));

        assertThat(hand.getState()).isInstanceOf(Normal.class);

        hand.receiveCards(new MockDeck(new Card(6)));

        assertThat(hand.getState()).isInstanceOf(Normal.class);
    }

    @Test
    void NORMAL_에서_BLACKJACK() {
        Hand hand = new Hand();

        assertThat(hand.getState()).isInstanceOf(Ready.class);

        hand.receiveCards(new MockDeck(new Card(5), new Card(6)));

        assertThat(hand.getState()).isInstanceOf(Normal.class);

        hand.receiveCards(new MockDeck(new Card(10)));

        assertThat(hand.getState()).isInstanceOf(BlackJack.class);
    }

    @Test
    void NORMAL에서_BUST() {
        Hand hand = new Hand();

        assertThat(hand.getState()).isInstanceOf(Ready.class);

        hand.receiveCards(createMock(8,6));

        assertThat(hand.getState()).isInstanceOf(Normal.class);

        hand.receiveCards(createMock(10));

        assertThat(hand.getState()).isInstanceOf(Bust.class);
    }

    private MockDeck createMock(int... scores) {

        Card[] cards = Arrays.stream(scores)
                .boxed()
                .map(score -> new Card(score))
                .toArray(Card[]::new);

        return new MockDeck(cards);
    }
}
