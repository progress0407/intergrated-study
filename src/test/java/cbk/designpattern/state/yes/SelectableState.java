package cbk.designpattern.state.yes;

public class SelectableState implements State {

    private static final State INSTANCE = new SelectableState();

    public static State getInstance() {
        return INSTANCE;
    }

    @Override
    public void increase(int coin, VendingMachine vendingMachine) {
        vendingMachine.insertCoin(coin);
    }

    @Override
    public void select(int productId, VendingMachine vendingMachine) {
        vendingMachine.provideProduct(productId);
        vendingMachine.decreaseCoin(productId);

        if (vendingMachine.hasNoCoin()) {
            vendingMachine.changeState(NoCoinState.getInstance());
        }
    }
}
