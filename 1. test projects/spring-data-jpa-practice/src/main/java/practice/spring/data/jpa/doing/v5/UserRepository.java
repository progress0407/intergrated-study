package practice.spring.data.jpa.doing.v5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

interface UserRepository extends JpaRepository<User, Long> {

    @Lock(LockModeType.OPTIMISTIC)
    @Query("select u from User u where u.id = :id")
    @QueryHints({
            @QueryHint(name = "javax.persistence.lock.timeout", value = "2000")
    })
    User findByIdWithLock(@Param("id") Long id);
}
