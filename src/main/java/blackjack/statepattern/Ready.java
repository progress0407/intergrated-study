package blackjack.statepattern;

class Ready implements State{

    @Override
    public int receiveTimes() {
        return 2;
    }

    @Override
    public void nextState(Hand hand) {
        if (hand.getScore() == 21) {
            hand.setState(new BlackJack());
            return;
        }
        hand.setState(new Normal());
    }
}
