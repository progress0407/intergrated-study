package blackjack.statepattern;

import static blackjack.statepattern.MatchResult.ORDINARY_WIN;
import static blackjack.statepattern.utils.CreationUtils.createMockDeck;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MatchResultTest {

    @Test
    void 딜러가_버스트이고_플레이어가_아니면_플레이어가_승리한다() {
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        playerHand.state();

        playerHand.receiveCards(createMockDeck(5, 6));
        dealerHand.receiveCards(createMockDeck(10, 10));

        dealerHand.receiveCards(createMockDeck(3));

        MatchResult matchResult = playerHand.match(dealerHand);

        assertThat(matchResult).isEqualTo(ORDINARY_WIN);
    }
}
