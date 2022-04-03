package cbk.designpattern.state.yes;

public interface State {
    void increase(int coin, VendingMachine vendingMachine);
    void select(int productId, VendingMachine vendingMachine);
}
