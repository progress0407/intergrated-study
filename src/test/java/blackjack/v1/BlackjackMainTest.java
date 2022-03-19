package blackjack.v1;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BlackjackMainTest {

    /**
     * Ace의 값은 개별적으로 변해야 하는데 각 카드에서 참조하는 Enum의 ACE 인스턴스는 하나이므로
     * 동시에 변경이 된다
     * 예) A스페이드, A다이아몬드, A콜로버, A하트
     */

    @Test
    void 개별_카드를_생성한다() {
        Card card = new Card(Denomination.TWO, Suit.HEART);
        out.println("Denomination.TWO.name() = " + Denomination.TWO.name());
    }

    @Test
    void 곱_순서쌍을_출력한다() {
        Denomination[] denominations = Denomination.values();
        Suit[] suits = Suit.values();

        for (Denomination denomination : denominations) {
            for (Suit suit : suits) {
                out.println(denomination.getName() + suit.getName());
            }
        }
    }

    @Test
    void 곱_순서쌍을_생성한다() {
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = cardDeck.getCards();

        Denomination[] denominations = Denomination.values();
        Suit[] suits = Suit.values();
        assertThat(cards.size()).isEqualTo(denominations.length * suits.length);
    }

    @Test
    void 생성된_순서쌍_중에서_ACE만_가져온다() {
        CardDeck cardDeck = new CardDeck();
        List<Card> findAceCards = cardDeck.findByDenomination(Denomination.ACE);
        findAceCards.forEach(out::println);
    }

    @Test
    void 덱에서_생성한_순서쌍_중에서_하나의_ACE의_값을_수정한다() {
        CardDeck cardDeck = new CardDeck();
        List<Card> findAceCards = cardDeck.findByDenomination(Denomination.ACE);
        out.println("------- before ------------");
        findAceCards.forEach(out::println);
        Card aceCardOne = findAceCards.get(0);
        out.println("aceCardOne = " + aceCardOne);
        aceCardOne.chooseAceValueAs11();
        out.println("------- after ------------");
        findAceCards.forEach(out::println);
    }
}
