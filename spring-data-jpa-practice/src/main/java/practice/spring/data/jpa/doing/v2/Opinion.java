package practice.spring.data.jpa.doing.v2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Opinion {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "discussion_id")
    @ManyToOne
    private Discussion discussion;
}
