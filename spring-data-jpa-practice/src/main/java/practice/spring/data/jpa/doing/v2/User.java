package practice.spring.data.jpa.doing.v2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id @GeneratedValue
    private Long id;
}
