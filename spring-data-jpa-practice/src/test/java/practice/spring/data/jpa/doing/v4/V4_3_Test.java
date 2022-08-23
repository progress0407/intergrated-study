package practice.spring.data.jpa.doing.v4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * No Spring
 */
public class V4_3_Test {

    // log
    Logger log = (Logger) LoggerFactory.getLogger(V4_3_Test.class);

    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("remind-hibernate");
    final EntityManager em = emf.createEntityManager();

    @Test
    void test_0() {
        final User user1 = new User();
        user1.setName("user-1");

        log.info("#1");

        final EntityTransaction tx = em.getTransaction();
        log.info("#2"); // tx x

        tx.begin();
        log.info("#3"); // tx o

        em.persist(user1);
        log.info("#5");

        em.flush();
        log.info("#6");

        tx.commit();
        log.info("#7"); // tx ox?
    }

    @Entity
    @Table(name = "`user`")
    class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        public void setId(final Long id) {
            this.id = id;
        }

        public void setName(final String name) {
            this.name = name;
        }
    }
}
