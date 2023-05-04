package jpa.app.shop.repository.trial_fail;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UtilsConcreteInterfaceRepository<T> implements UtilInterfaceRepository<T> {

    private final EntityManager em;

    @Override
    public void clear() {
        System.out.println("UtilsConcreteInterfaceRepository.clear");
        System.out.println("#this is 구현체 !");

//        Type type = getType();
//        System.out.println("type = " + type);
//        String className = ((Class) type).getSimpleName();
//        String sql = String.format("delete from %s", className);
//        em.createQuery(sql).executeUpdate();
//        em.flush();
//        em.clear();
    }

    private Type getType() {
        return ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }
}
