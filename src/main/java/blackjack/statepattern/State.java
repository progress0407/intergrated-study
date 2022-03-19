package blackjack.statepattern;

interface State {

    int receiveTimes();

    void nextState(Hand hand);
}
