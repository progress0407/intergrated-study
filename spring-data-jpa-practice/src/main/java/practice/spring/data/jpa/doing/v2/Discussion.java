package practice.spring.data.jpa.doing.v2;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.ToString;

//@Entity
@Data
@ToString(exclude = "opinions", callSuper = true)
class Discussion extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private int views;

    private boolean isAnonymous;

//    @OneToMany(mappedBy = "discussion")
//    private List<Opinion> opinions = new ArrayList<>();

    @Embedded
    private Opinions opinions = new Opinions();

    public void addOpinion(Opinion opinion) {
        opinions.getOpinions().add(opinion);
        opinion.setDiscussion(this);
    }
}
