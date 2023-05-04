package practice.spring.data.jpa.doing.v2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("user 예약어 및 테스트")
    @Test
    void test_1() {
        User user1 = new User("u-1");
        User user2 = new User("u-2");
        User user3 = new User("u-3");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        List<User> users = userRepository.findAll();

        assertThat(users.size()).isEqualTo(3);
    }
}