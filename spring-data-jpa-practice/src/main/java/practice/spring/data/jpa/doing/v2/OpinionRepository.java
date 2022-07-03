package practice.spring.data.jpa.doing.v2;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OpinionRepository {

    @PersistenceContext
    private EntityManager em;
}
