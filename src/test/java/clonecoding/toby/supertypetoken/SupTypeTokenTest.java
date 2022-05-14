package clonecoding.toby.supertypetoken;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

class SupTypeTokenTest {

    @Test
    void test_1() {
        // Local + Anonymous Class
        Sup<List<String>> b = new Sup<List<String>>() {

            {
                super.value = List.of("philz", "fields");
            }

            public void print() {
                out.println("parent value = " + super.value);
            }
        };

        b.print();

        Type t = b.getClass().getGenericSuperclass();
        ParameterizedType pType = (ParameterizedType) t;
        out.println(pType.getActualTypeArguments()[0]);
    }

    @Test
    void test2() {
        ParameterizedType pType = (ParameterizedType) (new Sup<List<String>>() {
        }).getClass().getGenericSuperclass();
        out.println(Arrays.toString(pType.getActualTypeArguments()));
    }

}