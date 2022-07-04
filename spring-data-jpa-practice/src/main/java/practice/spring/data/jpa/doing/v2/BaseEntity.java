package practice.spring.data.jpa.doing.v2;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Data;
import lombok.ToString;

@MappedSuperclass
@Data
public class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

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
