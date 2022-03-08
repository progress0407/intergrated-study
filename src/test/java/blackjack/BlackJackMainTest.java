package blackjack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BlackJackMainTest {

    @Test
    void 개별_카드를_생성한다() {
        Card card = new Card(Denomination.TWO, Suit.HEART);
        System.out.println("Denomination.TWO.name() = " + Denomination.TWO.name());
    }

    @Test
    void 곱_순서쌍을_출력한다() {
        Denomination[] denominations = Denomination.values();
        Suit[] suits = Suit.values();

        for (Denomination denomination : denominations) {
            for (Suit suit : suits) {
                System.out.println(denomination.getName() + suit.getName());
            }
        }
    }

    @Test
    void 곱_순서쌍을_생성한다() {
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = cardDeck.getCards();
        cards.forEach(System.out::println);

        Denomination[] denominations = Denomination.values();
        Suit[] suits = Suit.values();
        assertThat(cards.size()).isEqualTo(denominations.length * suits.length);
    }
}
