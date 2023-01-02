package practice.spring.data.jpa.doing.v2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;

//@Entity
//@Table(name = "`user`")
class User {

    @Id @GeneratedValue
    private Long id;

    private String name;

    public User(String name) {
        this.name = name;
    }
}
