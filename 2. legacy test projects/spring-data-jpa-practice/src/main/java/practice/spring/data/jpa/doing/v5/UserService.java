package practice.spring.data.jpa.doing.v5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User registerUser(User user) {

        return userRepository.save(user);
    }

    @Transactional
    public User changeUserName(Long id, String nameToChange) {

        User user = userRepository.findByIdWithLock(id);

        user.changeName(nameToChange);

        return user;
    }
}
