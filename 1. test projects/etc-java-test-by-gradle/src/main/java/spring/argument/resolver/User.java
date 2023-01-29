package spring.argument.resolver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String email;
    private String name;
    private String password;
}
