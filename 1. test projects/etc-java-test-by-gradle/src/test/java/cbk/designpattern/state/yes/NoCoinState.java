package cbk.designpattern.state.yes;

public class NoCoinState implements State {

    private static final NoCoinState INSTANCE = new NoCoinState();

    private NoCoinState() {
    }

    public static State getInstance() {
        return INSTANCE;
    }

    @Override
    public void increase(int coin, VendingMachine vendingMachine) {
        vendingMachine.changeState(SelectableState.getInstance());
        vendingMachine.increaseCoin(coin);
    }

    @Override
    public void select(int productId, VendingMachine vendingMachine) {
        SoundUtil.beep();
    }
}
