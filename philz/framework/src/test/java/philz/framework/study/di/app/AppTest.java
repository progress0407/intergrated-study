package philz.framework.study.di.app;

import java.util.Map;
import org.junit.jupiter.api.Test;
import philz.framework.study.di.container.PeanutBox;

public class AppTest {

    @Test
    void test() {
        PeanutBox.INSTANCE.init("philz.framework.study.di.peanuts");
        final Map<Class<?>, Object> peanutsCache = PeanutBox.INSTANCE.getPeanutsCache();
        for (final Object peanut : peanutsCache.values()) {
            System.out.println("peanut = " + peanut);
        }
    }
}
