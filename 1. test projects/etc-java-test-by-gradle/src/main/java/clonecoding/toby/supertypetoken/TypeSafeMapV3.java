package clonecoding.toby.supertypetoken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TypeSafeMapV3 {

    private Map<Type, Object> values = new HashMap<>();

    public <T> void put(TypeReferenceV2<T> typeReference, T value) {
        values.put(typeReference.getType(), value);
    }

    public <T> T get(TypeReferenceV2<T> typeReference) {
        Type type = typeReference.getType();
        Object findValue = values.get(typeReference.getType());
        if (type instanceof Class<?>) {
            return ((Class<T>) type).cast(findValue);
        }
        return ((Class<T>) ((ParameterizedType) type).getRawType()).cast(findValue); // T.R.<List<String>>>
    }
}
