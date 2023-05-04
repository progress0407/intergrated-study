package skeleton.code.spring.error.handle.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(TestConfig.class)
public class TestBeanTest {

    @Autowired
    Parent child;

    @Test
    void test() {
        child.print();
    }
}
