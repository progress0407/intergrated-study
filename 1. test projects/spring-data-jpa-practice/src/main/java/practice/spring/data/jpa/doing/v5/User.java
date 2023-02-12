package practice.spring.data.jpa.doing.v5;

import lombok.*;
import org.springframework.data.annotation.Version;

import javax.persistence.*;

@Entity
@Table(name = "`user`")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Data
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Version
    private long version;

    public void changeName(String nameToChange) {
        this.name = nameToChange;
    }
}
