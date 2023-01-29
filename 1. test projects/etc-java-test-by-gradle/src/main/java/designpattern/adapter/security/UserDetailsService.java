package designpattern.adapter.security;

public interface UserDetailsService {
    UserDetail loadUser(String username);
}
