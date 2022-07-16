package practice.spring.data.jpa.doing.v3;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
class UserRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserRepository(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User save(final User user) {
        entityManager.persist(user);
        return user;
    }

    public List<User> findByMeetingId(final Long meetingId) {
        return entityManager.createQuery("select u from User u where u.meeting.id = :meetingId", User.class)
                .setParameter("meetingId", meetingId)
                .getResultList();
    }
}
