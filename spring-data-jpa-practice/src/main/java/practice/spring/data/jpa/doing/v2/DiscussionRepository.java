package practice.spring.data.jpa.doing.v2;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;

@Repository
class DiscussionRepository {

    @PersistenceContext
    private EntityManager em;

    public Discussion save(Discussion discussion) {
        em.persist(discussion);
        return discussion;
    }

    public Optional<Discussion> findById(Long id) {
        return Optional.ofNullable(em.find(Discussion.class, id));
    }

    // SimpleJpaRepository 업데이트 로직이 아니다
    void update(Long id) {
        int rows = em.createQuery("update Discussion d set d.views = d.views + 1")
                .executeUpdate();
    }
}
