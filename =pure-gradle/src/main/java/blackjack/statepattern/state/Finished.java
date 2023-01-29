package blackjack.statepattern.state;

import blackjack.statepattern.Hand;

public abstract class Finished implements State {

    @Override
    public int receiveTimes() {
        return 0;
    }

    @Override
    public void nextState(Hand hand) {
    }
}
