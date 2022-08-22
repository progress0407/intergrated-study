package practice.spring.data.jpa.doing.v4;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class V4_Test {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @DisplayName("test-1")
    @Test
    void test_1() {
        final User user1 = User.builder().name("user-1").build();
        final User user2 = User.builder().name("user-2").build();

        userRepository.save(user1);
        userRepository.save(user2);

        final Team team1 = Team.builder().name("team-1").build();
        teamRepository.save(team1);

        teamRepository.delete(team1);

        userRepository.delete(user1);
        userRepository.delete(user2);
    }

    /**
     * 전자
     * isNew
     * 단순 JPA merge에서만 분기처리를 하는데 쓰이는건지?
     *
     * 후자
     * isNew가
     * PC 가 flush 될 당시에
     * DB 랑 불일치...
     * id null 인걸 insert
     *
     * isNew 메서드에서 결정이 되는 것인지!
     */

    /**
     * insert 도 변경감지를 해주나?
     */

    @DisplayName("test-2")
    @Test
    void test_2() {
        final User user1 = User.builder().name("user-1").build();
        final User user2 = User.builder().name("user-2").build();
        final User user3 = User.builder().name("user-2").build();
        final User user4 = User.builder().name("user-2").build();
        final User user5 = User.builder().name("user-2").build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        em.createQuery("delete from User u where u.id in :ids")
                .setParameter("ids", List.of(2L, 3L))
                .executeUpdate();

        user1.setName("something");
    }

    @DisplayName("test-3")
    @Test
    @Transactional
    void test_3() {
        final User user1 = User.builder().name("user-1").build();
        final User user2 = User.builder().name("user-2").build();
        final User user3 = User.builder().name("user-2").build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        em.createQuery("delete from User u where u.id in :ids")
                .setParameter("ids", List.of(2L, 3L))
                .executeUpdate();

        em.clear();

        userRepository.save(user1);

        System.out.println("-------------------- ## ----------------------------");
    }

    @DisplayName("test-4")
    @Test
    @Transactional
    void test_4() {
        final User user1 = User.builder().name("user-1").build();

        userRepository.save(user1);

        em.flush();
        em.clear();

        userRepository.deleteById(3L);

        System.out.println("-------------------- ## ----------------------------");
    }

    @DisplayName("test-5")
    @Test
    @Transactional
    void test_5() {
        final User user1 = User.builder().name("user-1").build();

        System.out.println("em = " + em);

        userRepository.save(user1);

        final User found1 = userRepository.findById(1L).get();
        System.out.println("em.contains(found1) = " + em.contains(found1));
        final User found2 = userRepository.findById(1L).get();
        System.out.println("em.contains(found2) = " + em.contains(found2));
    }

    @DisplayName("test-6")
    @Test
    void test_6() {
        final EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        final Member found = em.find(Member.class, 1L);
        final Optional<User> found2 = userRepository.findById(1L);
//        tx.commit();
//        em.close();
    }

    /**
     * entityManger가 다르더라도, 같은 트랜잭션이라면
     * 같은 영속성 컨텍스트를 타게 된다
     *
     */
    @DisplayName("test-7")
    @Test
    @Transactional
    void test_7() {
        /**
         * 만일 em 이 서로 다르다면...
         */
        final User user1 = User.builder().name("user-1").build();
        userRepository.save(user1);

        final User found2 = userRepository.findById(1L).get();
        System.out.println("em.contains(found2) = " + em.contains(found2)); // 여기서도 false
        em.clear();
        System.out.println("em.contains(found2) = " + em.contains(found2)); // 지우더라도 false
    }
}
