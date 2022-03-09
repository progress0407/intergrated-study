package blackjack.v4;

import static java.lang.System.out;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BlackJackMainTest {

    @Test
    void 덱에서_ACE를_찾을수_있다() {
        CardDeck cardDeck = new CardDeck();
        List<Card> findAceCards = cardDeck.findByDenomination(new AceDenomination());
        findAceCards.forEach(out::println);
    }

    @Test
    void 덱에서_TWO를_찾을수_있다() {
        CardDeck cardDeck = new CardDeck();
        List<Card> findCards = cardDeck.findByDenomination(Denomination.TWO);
        findCards.forEach(out::println);
    }

    @Test
    void 덱에서_생성한_순서쌍_중에서_하나의_ACE의_값을_수정한다() {
        CardDeck cardDeck = new CardDeck();
        List<Card> findAceCards = cardDeck.findByDenomination(new AceDenomination());
        out.println("------- before ------------");
        findAceCards.forEach(out::println);
        Card aceCardOne = findAceCards.get(0);
        out.println("aceCardOne = " + aceCardOne);
        aceCardOne.chooseAceValueAs11();
        out.println("------- after ------------");
        findAceCards.forEach(out::println);
    }

    @Test
    void 덱의_모든_점수를_구한다() {
        /**
         * ACE 0
         * 2 ~ 9
         * J, Q, K 10
         *
         * 0 + (2+..+9) + 10*3
         * 0 + 44 + 30 = 74
         *
         * 74*4 = 296
         */
        CardDeck cardDeck = new CardDeck();
        int scoreTotal = cardDeck.getScoreTotal();
        out.println("scoreTotal = " + scoreTotal);
    }
}
