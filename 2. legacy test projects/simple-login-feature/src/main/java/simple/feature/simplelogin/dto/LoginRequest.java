package simple.feature.simplelogin.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String name;
    private String pw;
}
