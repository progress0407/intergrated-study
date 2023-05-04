package blackjack.statepattern.state;

import blackjack.statepattern.Hand;

public interface State {

    int receiveTimes();

    void nextState(Hand hand);
}
