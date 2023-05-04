package clonecoding.toby.supertypetoken;

import java.lang.reflect.ParameterizedType;
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
        Object findValue = values.get(typeReference);
        if (type instanceof Class<?>) {
            return ((Class<T>) type).cast(findValue);
        }
        return ((Class<T>) ((ParameterizedType) type).getRawType()).cast(findValue); // T.R.<List<String>>>
    }
}
