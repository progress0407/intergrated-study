package practice.spring.data.jpa.doing.v4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TeamRepository extends JpaRepository<Team, Long> {
}
