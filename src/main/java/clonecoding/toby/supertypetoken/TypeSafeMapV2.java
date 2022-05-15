package clonecoding.toby.supertypetoken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TypeSafeMapV2 {

    private Map<TypeReference<?>, Object> values = new HashMap<>();

    public <T> void put(TypeReference<T> typeReference, T value) {
        values.put(typeReference, value);
    }

    public <T> T get(TypeReference<T> typeReference) {
        Type type = typeReference.getType();
        Object findValue = values.get(type);
        return ((Class<T>) type).cast(findValue);
    }
}
