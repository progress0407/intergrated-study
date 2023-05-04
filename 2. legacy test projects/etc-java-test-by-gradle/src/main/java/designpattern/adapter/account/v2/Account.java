package designpattern.adapter.account.v2;

import designpattern.adapter.security.UserDetail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account implements UserDetail {

    private String name;
    private String password;
    private String email;

    @Override
    public String getUsername() {
        return name;
    }
}
