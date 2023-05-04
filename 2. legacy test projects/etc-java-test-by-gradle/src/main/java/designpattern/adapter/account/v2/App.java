package designpattern.adapter.account.v2;

import designpattern.adapter.security.LoginHandler;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        LoginHandler loginHandler = new LoginHandler(accountService);
        String user = loginHandler.loadUser("keesun", "keesun");
        out.println("user = " + user);
    }
}
