package cbk.designpattern.state.yes;

class VendingMachine {

    private State state;

    private int coin = 0;

    public void insertCoin(int coin) {

    }

    public void select(int productId) {

    }

    void changeState(State state) {
        this.state = state;
    }

    public void increaseCoin(int coin) {
        this.coin += coin;
    }

    public void decreaseCoin(int productId) {
        int productCoin = getCoinByProductId(productId);
        this.coin -= productCoin;
    }

    public boolean hasNoCoin() {
        return this.coin == 0;
    }

    public void provideProduct(int productId) {

    }

    private int getCoinByProductId(int productId) {
        return 0;
    }
}
