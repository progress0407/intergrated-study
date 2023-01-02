package jpa.app.shop;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanRegisterConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
