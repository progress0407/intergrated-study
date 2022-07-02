package hellojpa.doing.v3;

import static java.lang.System.out;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hellojpa.doing.GlobalTestConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class PerformanceTest extends GlobalTestConfig {

    static final String MOCK_LOG = "##########\n"
            + "\t###############################\n"
            + "\t\t##########\n"
            + "\t\t####\t\n"
            + "\t\t\t###\t\n"
            + "\t\t\t########\n"
            + "\t\t######\n"
            + "\t\t\t###\n"
            + "#########################################################################################";


    @BeforeEach
    void setUp() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(new Car(1L));
        em.flush();
        tx.commit();
    }

    @DisplayName("성능 조회 - 영속성 컨텍스트")
    @Test
    void performance_test_1() {
        long start;
        long end;

        long[] elapsedTime = new long[10];

        for (int i = 0; i < 10; i++) {
            start = System.currentTimeMillis();
            for (int j = 0; j < 1_000; j++) {
                em.find(Car.class, 1L);
                log.info(MOCK_LOG);
            }
            end = System.currentTimeMillis();
            elapsedTime[i] = end - start;
        }

        long avg = 0L;
        for (int i = 0; i < 10; i++) {
            avg += elapsedTime[i];
        }
        avg /= 10L;

        out.println("avg = " + avg); // 25ms
    }

    @DisplayName("성능 조회 - 네트워크 (로컬 - was / tcp)")
    @Test
    void performance_test_2() {
        long start;
        long end;

        long[] elapsedTime = new long[10];

        em.clear();

        start = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 1_000; j++) {
                em.find(Car.class, 1L);
                em.clear();
            }
            end = System.currentTimeMillis();
            elapsedTime[i] = end - start;
        }

        long avg = 0L;
        for (int i = 0; i < 10; i++) {
            avg += elapsedTime[i];
        }
        avg /= 10L;

        out.println("avg = " + avg);
        // in memory    590ms
        // in tcp       1572ms
        // aws ...? real network  ??
    }
}
