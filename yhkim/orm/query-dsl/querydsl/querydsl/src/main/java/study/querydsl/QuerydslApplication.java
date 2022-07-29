package study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuerydslApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuerydslApplication.class, args);
    }

    /**
     * 어기에 주입되는 엔티티 매니저는 프록시이다
     * 또한 엔티티 매니저는 트랜잭션 단위로 1차 캐시를 할당해주기 때문에 동시성 문제를 걱정하지 않아도 된다
     */
    @Bean
    public JPAQueryFactory queryFactory(final EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}
