package basic.reflection.get_id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import lombok.SneakyThrows;

public abstract class AbstractRepository <T, ID>{

    @SneakyThrows({NoSuchMethodException.class, InvocationTargetException.class, IllegalAccessException.class})
    public ID save(T object) {
        Class clazz = getClazz();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            boolean hasId = hasId(field);
            if (hasId) {
                String idName = getIdName(field);
                Method method = clazz.getMethod("get" + idName);
                ID id = (ID) method.invoke(object);
                return id;
            }
        }
        throw new RuntimeException("save를 하는 과정 중에 에러가 발생했습니다.");
    }

    private boolean hasId(Field field) {
        return Arrays.stream(field.getDeclaredAnnotations()).anyMatch(annotation -> annotation instanceof Id);
    }

    private Class getClazz() {
        return (Class) getType();
    }

    private Type getType() {
        return ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    /**
     * 카멜케이스를 파스칼 케이스로 변환
     * ex) memberId -> MemberId
     */
    private String getIdName(Field field) {
        String tempIdName = field.getName();
        String firstCase = tempIdName.substring(0, 1);
        return firstCase.toUpperCase() + tempIdName.substring(1);
    }
}
