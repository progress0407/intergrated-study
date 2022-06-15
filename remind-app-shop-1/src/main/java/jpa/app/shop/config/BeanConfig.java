package jpa.app.shop.config;

import javax.persistence.EntityManager;
import jpa.app.shop.repository.trial_fail.MemberInterfaceRepository;
import jpa.app.shop.repository.trial_fail.UtilInterfaceRepository;
import jpa.app.shop.repository.trial_fail.UtilsConcreteInterfaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

    private final EntityManager em;

    @Bean
    public <T> UtilInterfaceRepository<T> utilInterfaceRepository() {
        return new UtilsConcreteInterfaceRepository<T>(em);
    }

    // spring load 시점에 실패, can not cast
//    @Bean
    public <T> MemberInterfaceRepository<T> concreteMemberTestRepository() {
        return (MemberInterfaceRepository) utilInterfaceRepository();
    }
}
