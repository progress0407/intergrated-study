package spring.argument.resolver;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
//@AllArgsConstructor
@ToString
public class UserRequestBody {
    private String email;
    private String name;
    private String password;
}
