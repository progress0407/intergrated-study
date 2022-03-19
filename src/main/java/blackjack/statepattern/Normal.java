package blackjack.statepattern;

class Normal implements State{
    @Override
    public int receiveTimes() {
        return 1;
    }

    @Override
    public void nextState(Hand hand) {
        if(21 == hand.getScore()) {
            hand.setState(new BlackJack());
            return;
        }

        if (21 < hand.getScore()) {
            hand.setState(new Bust());
        }
    }
}
