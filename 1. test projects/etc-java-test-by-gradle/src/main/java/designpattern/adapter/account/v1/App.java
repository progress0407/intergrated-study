package designpattern.adapter.account.v1;

import designpattern.adapter.security.LoginHandler;
import designpattern.adapter.security.UserDetailsService;

import static java.lang.System.out;

public class App {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);
        String user = loginHandler.loadUser("keesun", "keesun");
        out.println("user = " + user);
    }
}
