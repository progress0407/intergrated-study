package skeleton.code.spring.error.handle;

import java.util.IdentityHashMap;
import java.util.Map;

public class PrimitiveTest {

    public static void main(String[] args) {
        IdentityHashMap<Class<?>, Class<?>> map = new IdentityHashMap<>();
        map.put(Byte.class, byte.class);

        for (Map.Entry<Class<?>, Class<?>> entry : map.entrySet()) {
            System.out.printf("(k, v) = %s, %s \n", entry.getKey(), entry.getValue());
        }
    }
}
