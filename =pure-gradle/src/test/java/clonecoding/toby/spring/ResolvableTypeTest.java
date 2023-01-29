package clonecoding.toby.spring;

import clonecoding.toby.supertypetoken.TypeReferenceV2;
import org.junit.jupiter.api.Test;
import org.springframework.core.ResolvableType;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

class ResolvableTypeTest {

    @Test
    void t1() {
        ResolvableType resolvableType = ResolvableType.forClass(TypeReferenceV2.class);
    }

    @Test
    void t2() {
        ResolvableType resolvableType = ResolvableType.forInstance(new TypeReferenceV2<List<String>>() {
        });
        out.println(resolvableType.getSuperType().getGenerics().length);
        out.println(resolvableType.getSuperType().getGeneric(0).getType());
        out.println(resolvableType.getSuperType().getGeneric(0).getNested(0).getType());
        out.println(resolvableType.getSuperType().hasUnresolvableGenerics());
        out.println(resolvableType.hasUnresolvableGenerics());
    }

    @Test
    void t3() {
        ResolvableType resolvableType = ResolvableType.forInstance(new ArrayList<String>());
        out.println(resolvableType.hasUnresolvableGenerics());
        /**
         * 자바 차원에서 타입이 날라가기 때문에 해석할 수 없어...
         * 스프링이 아무리 날고 기더라도
         */
    }

}