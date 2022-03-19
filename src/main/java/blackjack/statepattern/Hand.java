package blackjack.statepattern;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private State state = new Ready();
    private List<Card> cards = new ArrayList<>();

    public int getScore() {
        return cards.stream()
                .mapToInt(it -> it.getScore())
                .sum();
    }

    public void receiveCards(Deck deck) {
        int receiveTimes = state.receiveTimes();
        for (int n = 0; n < receiveTimes; n++) {
            Card card = deck.drawCard();
            out.println(card + "를 넣었습니다 !");
            cards.add(card);
        }
        nextState();
    }

    public void nextState() {
        state.nextState(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
