package clonecoding.toby.me;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.ResolvableType;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class MyTypeSafeMapTest {

    @Test
    void t1() {
        MyTypeSafeMap map = new MyTypeSafeMap();
        ResolvableType resolvableType = ResolvableType.forInstance(new ArrayList<Integer>());
        map.put(resolvableType.getType(), new ArrayList<>(List.of(1,2,3)));
        out.println("map.get(resolvableType.getType()) = " + map.get(resolvableType.getType()));
    }
}
