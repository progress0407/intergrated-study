package account;

public class BrokenAccount extends Account {

    public BrokenAccount(String name) {
        super(name);
    }

    @Override
    protected void finalize() throws Throwable {
        this.transfer(1_000_000_000, "keesun");
    }
}
