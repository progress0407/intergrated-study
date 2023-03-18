package study.querydsl.config;

import com.p6spy.engine.spy.P6SpyOptions;
import com.querydsl.core.annotations.Config;

import javax.annotation.PostConstruct;

@Config
public class P6SpyConfig {

    @PostConstruct
    public void setLogMessageFormat() {
        P6SpyOptions.getActiveInstance().setLogMessageFormat(PrettySqlFormatter.class.getName());
    }
}
