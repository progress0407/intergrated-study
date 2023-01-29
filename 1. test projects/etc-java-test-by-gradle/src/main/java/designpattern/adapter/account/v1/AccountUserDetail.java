package designpattern.adapter.account.v1;

import designpattern.adapter.security.UserDetail;

public class AccountUserDetail implements UserDetail {

    private Account account;

    public AccountUserDetail(Account account) {
        this.account = account;
    }

    @Override
    public String getUsername() {
        return this.account.getName();
    }

    @Override
    public String getPassword() {
        return this.account.getPassword();
    }
}
