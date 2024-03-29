package practice.spring.data.jpa.doing.v3;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository
@Transactional(readOnly = true)
public class MeetingRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public MeetingRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Meeting save(final Meeting meeting) {
        entityManager.persist(meeting);
        return meeting;
    }

    public Optional<Meeting> findById(final Long id) {
        final Meeting meeting = entityManager.find(Meeting.class, id);
        return Optional.ofNullable(meeting);
    }
}
