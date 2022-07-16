package skeleton.code.spring.error.handle.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean filter() {
        FilterRegistrationBean<Filter> filterBean = new FilterRegistrationBean<>();
        filterBean.setFilter(new ErrorFilter());
        filterBean.setOrder(1);
        filterBean.addUrlPatterns("/*");
        return filterBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ErrorInterceptor());
//                .excludePathPatterns("/error");
    }

    /*
    @Bean
    public Filter errorFilter() {
        return new ErrorFilter();
    }
    */
}
