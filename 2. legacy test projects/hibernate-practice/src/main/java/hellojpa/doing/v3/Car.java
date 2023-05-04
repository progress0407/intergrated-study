package hellojpa.doing.v3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "car_id")
    private Long id;

}
