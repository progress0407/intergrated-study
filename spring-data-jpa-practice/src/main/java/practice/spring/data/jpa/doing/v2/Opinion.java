package practice.spring.data.jpa.doing.v2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "discussion")
public class Opinion {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "discussion_id")
    @ManyToOne
    private Discussion discussion;
}
