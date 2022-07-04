package practice.spring.data.jpa.doing.v2;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;

@Repository
public class DiscussionRepository {

    @PersistenceContext
    private EntityManager em;

    public Discussion save(Discussion discussion) {
        em.persist(discussion);
        return discussion;
    }

    public Optional<Discussion> findById(Long id) {
        return Optional.ofNullable(em.find(Discussion.class, id));
    }
}
