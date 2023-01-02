package practice.spring.data.jpa.doing.config;

import static java.lang.System.out;

import java.lang.reflect.Method;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {

    @Autowired
    private AopTargetParent aopTargetParent;

    @Autowired
    private AopTargetChild aopTargetChild;

    @Autowired
    private AopTargetChild aopTargetChild2;

    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();


    @Test
    void test_1() throws NoSuchMethodException {
        out.println(aopTargetParent.getClass());

        Method targetMethod = AopTargetParent.class.getMethod("doo");

        pointcut.setExpression("execution(* practice.spring.data.jpa.doing.config.AopTargetParent.*(..))");
        Assertions.assertThat(pointcut.matches(targetMethod, AopTargetParent.class)).isTrue();
    }

    @Test
    void test_2() throws NoSuchMethodException {
        out.println(aopTargetChild.getClass());

        Method targetMethod = AopTargetChild.class.getMethod("doo");

        pointcut.setExpression("execution(* practice.spring.data.jpa.doing.config.AopTargetParent.*(..))");
        Assertions.assertThat(pointcut.matches(targetMethod, AopTargetChild.class)).isTrue();
    }

    @Test
    void test_3() throws NoSuchMethodException {
        out.println(aopTargetChild2.getClass());

        Method targetMethod = AopTargetChild2.class.getMethod("doo");

        pointcut.setExpression("execution(* practice.spring.data.jpa.doing.config.AopTargetInterface.*(..))");
        Assertions.assertThat(pointcut.matches(targetMethod, AopTargetChild2.class)).isTrue();
    }

    @Test
    void test_4() throws NoSuchMethodException {
        out.println(aopTargetChild.getClass());

        Method targetMethod = AopTargetChild2.class.getMethod("doo");

        pointcut.setExpression("execution(* practice.spring.data.jpa.doing.config.AopTargetInterface4.*(..))");
        Assertions.assertThat(pointcut.matches(targetMethod, AopTargetChild2.class)).isTrue();
    }

    @Test
    void test_5() {
        aopTargetParent.doo();
        aopTargetChild.doo();
        aopTargetChild2.doo();
    }
}
