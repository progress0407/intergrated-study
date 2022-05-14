package clonecoding.toby.typetoken;

import java.util.HashMap;
import java.util.Map;

public class TypeSafeMap {
    private Map<Class<?>, Object> values = new HashMap<>();

    <T> void put(Class<T> clazz, T value) {
        values.put(clazz, value);
    }

    <T> T get(Class<T> clazz) {
        return clazz.cast(values.get(clazz));
    }
}