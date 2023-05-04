package clonecoding.toby.supertypetoken;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class TypeSafeMapV3Test {

    @Test
    void t1() {
        TypeSafeMapV3 map = new TypeSafeMapV3();
        map.put(new TypeReferenceV2<>(){}, 1_000);
        map.put(new TypeReferenceV2<>(){}, "String");
        map.put(new TypeReferenceV2<List<Integer>>(){}, List.of(1, 2, 3));
        map.put(new TypeReferenceV2<List<String>>(){}, List.of("A", "B", "C"));
        map.put(new TypeReferenceV2<List<Character>>(){}, List.of('a', 'b', 'c'));
        map.put(new TypeReferenceV2<List<Object>>(){}, List.of(1, "A", 'c'));
        map.put(new TypeReferenceV2<List<List<String>>>(){},
                List.of(List.of("A"), List.of("B"), List.of("C-1", "C-2")));

        out.println(map.get(new TypeReferenceV2<Integer>(){}));
        out.println(map.get(new TypeReferenceV2<String>(){}));
        out.println(map.get(new TypeReferenceV2<List<Character>>(){}));
        out.println(map.get(new TypeReferenceV2<List<String>>(){}));
        out.println(map.get(new TypeReferenceV2<List<Object>>(){}));
        out.println(map.get(new TypeReferenceV2<List<List<String>>>(){}));
    }
}