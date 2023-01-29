package spring.argument.resolver;

import clonecoding.toby.spring.ResolvableTypeMain;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class UserResponse {
    private String email;
    private String name;

    private UserResponse() {
    }

    public static UserResponse from(User user) {
        return new UserResponse(user.getEmail(), user.getName());
    }
}
