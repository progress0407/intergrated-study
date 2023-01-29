package designpattern.adapter.account.v1;

import designpattern.adapter.security.UserDetail;
import designpattern.adapter.security.UserDetailsService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountUserDetailService implements UserDetailsService {

    private final AccountService accountService;
    @Override
    public UserDetail loadUser(String username) {
        Account account = accountService.findAccountByUsername(username);
        return new AccountUserDetail(account);
    }
}
