package simple.feature.simplelogin.repository;

import org.springframework.stereotype.Component;
import simple.feature.simplelogin.domain.User;

import java.util.HashMap;

@Component
public class UserRepository {

    private Long id_number = 0L;
    private final HashMap<Long, User> database = new HashMap<>();

    public Long insert(User user) {

        id_number++;
        user.setId(id_number);

        database.put(id_number, user);

        return id_number;
    }

    public User findById(Long userId) {

        return database.get(userId);
    }

    public User findByName(String userName) {

        User findUser = database.values().stream()
                .filter(it -> it.getName().equals(userName))
                .findAny()
                .orElse(null);

        return findUser;
    }
}
