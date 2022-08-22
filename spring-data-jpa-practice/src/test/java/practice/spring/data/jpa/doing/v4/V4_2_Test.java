package practice.spring.data.jpa.doing.v4;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
public class V4_2_Test {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    @Commit
    void test_1() {
        final User user1 = User.builder().name("user-1").build();

        userRepository.save(user1);
    }
}
