package jpa.app.shop.repository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
public abstract class BasicCrudRepository<T, ID> {

    @PersistenceContext
    protected EntityManager em;

    public ID save(T object) {
        ID id = getId(object);
        if (id == null) {
            em.persist(object);
        } else {
            em.merge(object);
        }
        return getId(object);
    }

    public List<T> findAll() {
        String sql = String.format("select x from %s x", getClassName());
        return em.createQuery(sql, getClazz())
                .getResultList();
    }

    public Optional<T> findById(ID id) {
        T find = em.find(getClazz(), id);
        return Optional.ofNullable(find);
    }

    public void delete(T object) {
        em.remove(object);
    }

    public void deleteById(ID id) {
        T find = findById(id).orElse(null);
        em.remove(find);
    }

    public void clear() {
        String className = getClassName();
        String sql = String.format("delete from %s", className);
        em.createQuery(sql).executeUpdate();
        em.flush();
        em.clear();
    }

    private Class<T> getClazz() {
        return (Class<T>) getType();
    }

    private String getClassName() {
        return getClazz().getSimpleName();
    }

    private Type getType() {
        return ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    private boolean hasIdAnnotation(Field field) {
        return Arrays.stream(field.getDeclaredAnnotations()).anyMatch(annotation -> annotation instanceof Id);
    }

    @SneakyThrows({NoSuchMethodException.class, InvocationTargetException.class, IllegalAccessException.class})
    private ID getId(Object object) {
        Class clazz = getClazz();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) { // e.g) id, name, add...
            boolean hasIdAnnotation = hasIdAnnotation(field);
            if (hasIdAnnotation) {
                String idName = getIdNameByPascalCase(field); // e.g) Id
                Method method = clazz.getMethod("get" + idName); // e.g) getId
                ID id = (ID) method.invoke(object);
                return id;
            }
        }
        throw new RuntimeException("save를 하는 과정 중에 에러가 발생했습니다.");
    }

    /**
     * 카멜케이스를 파스칼 케이스로 변환 ex) memberId -> MemberId
     */
    private String getIdNameByPascalCase(Field field) {
        String tempIdName = field.getName();
        String firstCase = tempIdName.substring(0, 1);
        return firstCase.toUpperCase() + tempIdName.substring(1);
    }
}
