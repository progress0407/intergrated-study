package clonecoding.toby.me;

import lombok.val;
import org.springframework.core.ResolvableType;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MyTypeSafeMap {

    private Map<Type, Object> values = new HashMap<>();

    public <T> void put(Type type, T value) {
        values.put(type, value);
    }

    public <T> T get(Type type) {
        Object findValue = values.get(type);
        if (type instanceof Class<?>) {
            return ((Class<T>) type).cast(findValue);
        }
        return ((Class<T>) ((ParameterizedType) type).getRawType()).cast(findValue);
    }
}
