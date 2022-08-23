package practice.spring.data.jpa.doing.v4;

import static org.junit.jupiter.api.Assertions.assertFalse;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * DB와 Tx 실험
 */
@SpringBootTest
public class V4_2_Test {

    // log
    Logger log = (Logger) LoggerFactory.getLogger(V4_2_Test.class);

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    // Test Fixture
    final User user1 = User.builder().name("user-1").build();

    @Test
    void txTest() {
        log.info("hello");
        assertFalse(TransactionSynchronizationManager.isActualTransactionActive());
    }

    @Test
    @Commit
    void test_0() {
        log.info("#1");
        final EntityTransaction tx = em.getTransaction(); // Spring Annotaion을 사용해야 한다고 경고
        log.info("#2");
        tx.begin();
        em.persist(user1);
        em.flush();
        tx.commit();
    }

    @DisplayName("수동 flush 한 후 DB에 데이터가 있는가")
    @Test
    @Transactional
    @Commit
    void test_1() {
        log.info("hello");
        final EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(user1);
        em.flush();
        tx.commit();
    }

    @DisplayName("flush 를 한 후 DB에 데이터가 있는가")
    @Test
    @Commit
    void test_2() {
        userRepository.save(user1);

        System.out.println("----");

        em.flush();

        System.out.println("----");
    }
}
