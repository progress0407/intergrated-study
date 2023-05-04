package clonecoding.toby.spring;

import clonecoding.toby.supertypetoken.TypeReferenceV2;
import org.springframework.core.ResolvableType;

import java.util.List;

import static java.lang.System.out;

public class ResolvableTypeMain {

    public static void main(String[] args) {
//        ResolvableType resolvableType = ResolvableType.forClass(TypeReferenceV2.class);
        ResolvableType resolvableType = ResolvableType.forInstance(new TypeReferenceV2<List<String>>(){});
        out.println(resolvableType.getSuperType().getGenerics().length);
        out.println(resolvableType.getSuperType().getGeneric(0).getType());
        out.println(resolvableType.getSuperType().getGeneric(0).getNested(0).getType());
        out.println(resolvableType.getSuperType().hasUnresolvableGenerics());
        out.println(resolvableType.hasUnresolvableGenerics());
    }
}
