package practice.spring.data.jpa.doing.v4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Commit;

/**
 * No Spring
 */
public class V4_3_Test {

    // log
    Logger log = (Logger) LoggerFactory.getLogger(V4_3_Test.class);

    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("remind-hibernate");
    final EntityManager em = emf.createEntityManager();

    @Test
//    @Commit
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

    @DisplayName("remove 확인")
    @Test
    void test_1() {
        final User user1 = new User();
        user1.setName("user-1");

        final EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(user1); // insert

        em.remove(user1);
        System.out.println(">>>>>>>>>>>> em.contains(user1) = " + em.contains(user1)); // false
        final User foundUser = em.find(User.class, user1.getId());
        System.out.println(">>>>>>>>>>>> foundUser = " + foundUser); // null : not found

        System.out.println(">>>>>>>>>>>> flush start >>>>>>>>>>>>");
        em.flush();                                                     // 쓰기 지연 저장소에 아래의 쿼리 등록
        System.out.println(">>>>>>>>>>>> flush end >>>>>>>>>>>>");

        System.out.println(">>>>>>>>>>>> commit start >>>>>>>>>>>>");
        tx.commit();                                                   //
        System.out.println(">>>>>>>>>>>> commit end >>>>>>>>>>>>");
    }
}
