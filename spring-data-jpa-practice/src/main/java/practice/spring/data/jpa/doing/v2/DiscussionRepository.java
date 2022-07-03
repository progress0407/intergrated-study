package practice.spring.data.jpa.doing.v2;

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
}
