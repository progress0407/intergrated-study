package spring.argument.resolver;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@ToString
public class UserModelAttributeV1 {
    private String email;
    private String name;
    private String password;
}
