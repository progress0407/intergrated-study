package clonecoding.toby.supertypetoken;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

class SupTypeTokenTest {
    @Test
    void 상속을_이용한_익명_클래스() {
        class MySub extends Sup<List<String>> {
        }

        MySub mySub = new MySub();
        out.println("mySub.getClass() = " + mySub.getClass());
    }

    @Test
    void t2() {

        Sup<List<String>> sup = new Sup<>();
        out.println("sup = " + sup);
        out.println("sup.getClass() = " + sup.getClass());

        // Local + Anonymous + Inheritance Class
        Sup<List<String>> sub = new Sup<>() {
            {
                super.value = List.of("philz", "fields");
            }

            public void print() {
                out.println("parent value = " + super.value);
            }
        };

        sub.print();

        out.println("sub = " + sub);
        out.println("sub.getClass() = " + sub.getClass());


        Type type = sub.getClass().getGenericSuperclass();
        out.println("type = " + type.getClass());
        ParameterizedType parameterizedTypeType = (ParameterizedType) type;
        out.println("parameterizedTypeType = " + parameterizedTypeType.getClass());
        out.println(parameterizedTypeType.getActualTypeArguments()[0]);
    }

    @Test
    void t3() {
        ParameterizedType pType = (ParameterizedType) (new Sup<List<String>>() {
        }).getClass().getGenericSuperclass();
        out.println(Arrays.toString(pType.getActualTypeArguments()));
    }

}