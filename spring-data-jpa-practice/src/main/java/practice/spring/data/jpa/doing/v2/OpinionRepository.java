package practice.spring.data.jpa.doing.v2;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OpinionRepository {

    @PersistenceContext
    private EntityManager em;

    public Opinion save(Opinion opinion) {
        em.persist(opinion);
        return opinion;
    }

    public Optional<Opinion> findById(Long id) {
        return Optional.ofNullable(em.find(Opinion.class, id));
    }
}
