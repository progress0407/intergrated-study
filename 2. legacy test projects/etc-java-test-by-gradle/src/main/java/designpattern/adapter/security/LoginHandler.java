package designpattern.adapter.security;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginHandler {
    private final UserDetailsService userDetailsService;

    public String loadUser(String username, String password) {
        UserDetail userDetails = userDetailsService.loadUser(username);
        if (userDetails.getPassword().equals(password)) {
            return userDetails.getUsername();
        }
        throw new IllegalArgumentException();
    }
}
