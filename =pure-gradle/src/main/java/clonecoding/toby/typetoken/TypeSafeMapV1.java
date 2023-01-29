package clonecoding.toby.typetoken;

import java.util.HashMap;
import java.util.Map;

public class TypeSafeMapV1 {
    private Map<Class<?>, Object> values = new HashMap<>();

    public <T> void put(Class<T> clazz, T value) {
        values.put(clazz, value);
    }

    public <T> T get(Class<T> clazz) {
        return clazz.cast(values.get(clazz));
    }
}