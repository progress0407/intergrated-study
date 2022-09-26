package philz.framework.study.di.container;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;
import philz.framework.study.di.anno.ImPeanut;
import philz.framework.study.di.anno.LargePeanut;
import philz.framework.study.di.anno.MiddlePeanut;
import philz.framework.study.di.anno.SmallPeanut;

public enum PeanutBox {

    INSTANCE;

    private Map<Class<?>, Object> peanutsCache = new HashMap<>();

    public void init(final String path) {
        try {
            initInternal(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Map<Class<?>, Object> getPeanutsCache() {
        return peanutsCache;
    }

    private void initInternal(final String path) throws Exception {
        final Set<Class<?>> peanutTypes = getTypeWithPeanutAnnotated(path);
        for (final Class<?> peanutType : peanutTypes) {
            final Object peanutInstance = dfs(peanutType);
            peanutsCache.putIfAbsent(peanutType, peanutInstance);
        }
    }

    private Set<Class<?>> getTypeWithPeanutAnnotated(final String path) {
        final Reflections reflections = new Reflections(path);
        final Set<Class<?>> peanuts = reflections.getTypesAnnotatedWith(ImPeanut.class);
        peanuts.addAll(reflections.getTypesAnnotatedWith(LargePeanut.class));
        peanuts.addAll(reflections.getTypesAnnotatedWith(MiddlePeanut.class));
        peanuts.addAll(reflections.getTypesAnnotatedWith(SmallPeanut.class));
        return peanuts;
    }

    private Object dfs(final Class<?> peanut)
            throws InstantiationException, IllegalAccessException, InvocationTargetException {
        if (isAlreadyExistPeanut(peanut)) {
            return peanutsCache.get(peanut);
        }
        final Constructor<?> defaultConstructor = getDefaultConstructor(peanut);
        if (hasDefaultConstructor(defaultConstructor)) {
            return defaultConstructor.newInstance();
        }
        final Constructor<?>[] constructors = peanut.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new RuntimeException("Peanut은 하나의 생성자만을 가져야 합니다.");
        }
        final Constructor<?> constructor = constructors[0];
        final Class<?>[] parameterTypes = constructor.getParameterTypes();
        final Object[] parameterInstances = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            final Class<?> parameterType = parameterTypes[i];
            final Object parameterInstance = dfs(parameterType);
            peanutsCache.putIfAbsent(parameterType, parameterInstance);
            parameterInstances[i] = parameterInstance;
        }
        return constructor.newInstance(parameterInstances);
    }

    private boolean hasDefaultConstructor(final Constructor<?> defaultConstructor) {
        return defaultConstructor != null;
    }

    private Constructor<?> getDefaultConstructor(final Class<?> peanut) {
        try {
            return peanut.getConstructor(null);
        } catch (NoSuchMethodException e) {
            return null;
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isAlreadyExistPeanut(final Class<?> peanut) {
        return peanutsCache.get(peanut) != null;
    }
}
