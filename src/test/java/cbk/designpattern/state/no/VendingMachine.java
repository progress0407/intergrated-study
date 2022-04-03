package cbk.designpattern.state.no;

class VendingMachine {

    private static enum State {NO_COIN, SELECTABLE, SOLD_OUT}

    private State state;

    public void insertCoin(int coin) {
        switch (state) {
            case NO_COIN:
                insertCoin(coin);
                state = State.SELECTABLE;
                break;

            case SELECTABLE:
                insertCoin(coin);
                break;

            case SOLD_OUT:
                returnCoin(coin);
                break;
        }
    }

    public void select(int productId) {
        switch (state) {
            case NO_COIN:
                break;

            case SELECTABLE:
                provideProduct(productId);
                decreaseCoin();
                break;

            case SOLD_OUT:
                break;
        }
    }

    public int returnCoin(int coin) {
        switch (state) {
            case NO_COIN:
            case SELECTABLE:
            case SOLD_OUT:
                return coin;
        }
        return coin;
    }

    private void provideProduct(int productId) {

    }

    private void decreaseCoin() {

    }
}
