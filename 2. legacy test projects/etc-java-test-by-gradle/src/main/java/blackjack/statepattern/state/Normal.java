package blackjack.statepattern.state;

import static blackjack.statepattern.state.StateContainer.BUST;

import blackjack.statepattern.Hand;

public class Normal extends UnFinished {

    @Override
    public int receiveTimes() {
        return 1;
    }

    @Override
    public void nextState(Hand hand) {
        if (21 < hand.score()) {
            hand.setState(BUST);
        }
    }
}
