package skeleton.code.spring.error.handle.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class TestConfig {

    @Bean("childDev")
    @Primary
//    @Qualifier("childDev")
    public Parent childDev() {
        return new ChildDev();
    }
}
