package practice.spring.data.jpa.doing.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAop {

    @Before("execution(* practice.spring.data.jpa.doing.config.AopTargetParent.*(..))")
    public void aop1(JoinPoint joinPoint) {
        log.info("[info log] signature = {}", joinPoint.getSignature());
    }

    @Before("execution(* practice.spring.data.jpa.doing.config.AopTargetInterface.*(..))")
    public void aop2(JoinPoint joinPoint) {
        log.info("[info log] signature = {}", joinPoint.getSignature());
    }

    @Before("execution(* java.sql.Statement.*(..))")
    public void aop3(JoinPoint joinPoint) {
        log.info("[info log] signature = {}", joinPoint.getSignature());
    }

    @Before("execution(* java.sql.PreparedStatement.*(..))")
    public void aop4(JoinPoint joinPoint) {
        log.info("[info log] signature = {}", joinPoint.getSignature());
    }

    @Before("execution(* com.zaxxer.hikari.pool.ProxyPreparedStatement.*(..))")
    public void aop5(JoinPoint joinPoint) {
        log.info("[info log] signature = {}", joinPoint.getSignature());
    }

    @Before("execution(* org.springframework.data.jpa.repository.JpaRepository.*(..))")
    public void aop6(JoinPoint joinPoint) {
        log.info("[info log] signature = {}", joinPoint.getSignature());
    }
}
