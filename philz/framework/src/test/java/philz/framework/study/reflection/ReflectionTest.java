package philz.framework.study.reflection;

import java.util.Set;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

public class ReflectionTest {

    @Test
    void test() {
        final Reflections reflections = new Reflections("philz.framework.study.reflection");
        final Set<Class<? extends A>> objects = reflections.getSubTypesOf(A.class);
        System.out.println("objects = " + objects);
    }
}
