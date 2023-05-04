package account;

import static java.lang.System.out;

import org.junit.jupiter.api.Test;

class AccountMain {

    @Test
    void test() {
        Account account = new Account("푸틴");
        account.transfer(5_000, "미국");
    }

    @Test
    void test2() {
        Account account = new Account("러시아");
        account.transfer(5_000, "미국");
    }

    @Test
    void test3() throws InterruptedException {
        String name = "러시아";
        Account account = null;
        try {
            account = new BrokenAccount("푸틴");
        } catch (Exception exception) {
            out.println("푸틴은 안되는데??");
        }
        System.gc();
        Thread.sleep(3000L);

        account.transfer(100, "keesun");
    }
    @Test
    void test4() throws InterruptedException {
        String name = "러시아";
        Account account = null;
        try {
            account = new BrokenAccount("푸틴");
        } catch (Exception exception) {
            out.println("푸틴은 안되는데??");
        }
        account.transfer(100, "keesun");
    }

}
