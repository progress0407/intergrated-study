package practice.spring.data.jpa.doing.v2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Data;

@Entity
@Data
public class Discussion {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private int views;

    private boolean isAnonymous;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "discussion")
    private List<Opinion> opinions = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        System.out.println("Discussion.firstSave");
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("Discussion.preUpdate");
        updatedAt = LocalDateTime.now();
    }

}
