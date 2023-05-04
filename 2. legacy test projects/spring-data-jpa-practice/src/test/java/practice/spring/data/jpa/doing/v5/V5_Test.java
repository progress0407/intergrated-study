package practice.spring.data.jpa.doing.v5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class V5_Test {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

/*
    @Test
    @Transactional
    void test() {

        User user = User.builder()
                .name("hello")
                .build();

        userRepository.save(user);

        User findUser = userRepository.findByIdWithLock(user.getId());

        System.out.println("findUser = " + findUser);
    }
*/

    @Test
    void changeUserName() {

        User user = User.builder()
                .name("hello")
                .build();

        User savedUser = userService.registerUser(user);

        User changedUser = userService.changeUserName(savedUser.getId(), "nice to meet you");

        System.out.println("changedUser = " + changedUser);
    }
}
