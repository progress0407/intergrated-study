package practice.spring.data.jpa.doing.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AopConfiguration {

//    private final ProxyPreparedStatement proxyPreparedStatement;
//    private final HikariProxyCallableStatement hikariProxyCallableStatement;
//    private final HikariProxyPreparedStatement hikariProxyPreparedStatement;
//    private final HikariProxyConnection hikariProxyConnection;
//    private final PreparedStatement preparedStatement;

    @Bean
    public AopTargetParent aopTargetParent() {
        return new AopTargetParent();
    }

    @Bean
    public AopTargetChild aopTargetChild() {
        return new AopTargetChild();
    }
}
