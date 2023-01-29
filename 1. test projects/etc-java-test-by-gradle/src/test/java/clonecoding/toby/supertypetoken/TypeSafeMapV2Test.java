package clonecoding.toby.supertypetoken;

import clonecoding.toby.typetoken.TypeSafeMapV1;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.System.out;

class TypeSafeMapV2Test {

    @Test
    void t1() {
        TypeSafeMapV2 map = new TypeSafeMapV2();
        map.put(new TypeReference<>(){}, 1_000);
        map.put(new TypeReference<>(){}, "String");
        map.put(new TypeReference<List<Integer>>(){}, List.of(1, 2, 3));
        map.put(new TypeReference<List<String>>(){}, List.of("A", "B", "C"));
        map.put(new TypeReference<List<Character>>(){}, List.of('a', 'b', 'c'));
        map.put(new TypeReference<List<Object>>(){}, List.of(1, "A", 'c'));

        out.println(map.get(new TypeReference<Integer>(){}));
        out.println(map.get(new TypeReference<String>(){}));
        out.println(map.get(new TypeReference<List<Character>>(){}));
        out.println(map.get(new TypeReference<List<String>>(){}));
        out.println(map.get(new TypeReference<List<Object>>(){}));
    }

}