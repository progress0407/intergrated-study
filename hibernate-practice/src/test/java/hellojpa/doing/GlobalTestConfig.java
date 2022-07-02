package hellojpa.doing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GlobalTestConfig {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("remind-hibernate");
    protected EntityManager em = emf.createEntityManager();
}
