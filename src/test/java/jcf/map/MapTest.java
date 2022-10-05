package jcf.map;

import static java.lang.System.out;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import mybenchmark.testclasses.HashMapClass;
import org.junit.jupiter.api.Test;

public class MapTest {

    @Test
    void HashMapTest() {
        final HashMap<Human, Integer> map = new HashMap<>();

        final Human human_1 = new Human(1L, "swcho");
        final Human human_2 = new Human(2L, "swcho");

        map.put(human_1, 100);
        map.put(human_2, 200);

        out.println("map.size() = " + map.size());

        final Integer age = map.get(human_1);
        out.println("age = " + age);
    }

    private static class Human {

        Long id;
        String name;

        public Human(final Long id, final String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Human human = (Human) o;
            return Objects.equals(id, human.id) && Objects.equals(name, human.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
