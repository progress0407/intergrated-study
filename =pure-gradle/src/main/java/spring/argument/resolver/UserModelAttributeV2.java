package spring.argument.resolver;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserModelAttributeV2 {
    private String email;
    private String name;
    private String password;
}
