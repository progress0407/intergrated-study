package clonecoding.toby.typetoken;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

class TypeTokenTest {

    @DisplayName("[예외] 타입 세이프하지 않은 변환을 한다")
    @Test
    void canNotTypeCast() {
        Map<String, Object> map = new HashMap<>();
        map.put("key-1", 1_000);

        String str = (String) map.get("key-1");
        out.println("str = " + str);
    }

    @DisplayName("타입 세이프한 맵")
    @Test
    void typeSafeMap() {
        TypeSafeMap typeSafeMap = new TypeSafeMap();
        typeSafeMap.put(Integer.class, 1_1000);
        typeSafeMap.put(String.class, "String");
        typeSafeMap.put(List.class, List.of(1, 2, 3));
        typeSafeMap.put(List.class, List.of("A", "B", "C"));
        typeSafeMap.put(List.class, List.of('a', 'b', 'c'));
        typeSafeMap.put(List.class, List.of(1, "A", 'c'));

        out.println(typeSafeMap.get(Integer.class));
        out.println(typeSafeMap.get(String.class));
        out.println(typeSafeMap.get(List.class));
    }
}