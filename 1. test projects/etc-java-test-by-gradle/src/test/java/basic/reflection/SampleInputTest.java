package basic.reflection;

import basic.reflection.piece.Piece;
import basic.reflection.utils.RecursiveInput;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.support.ReflectionSupport;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

class SampleInputTest {

    @Test
    void test() {
        String pathName = Piece.class.getPackage().getName();
        String replacedPathName = pathName.replaceAll("\\.", "\\\\");
        Path currentPath = Paths.get("" + replacedPathName);
        URI uri = currentPath.toUri();
        List<Class<?>> allClasses =
                ReflectionSupport.findAllClassesInClasspathRoot(uri, type -> true, name -> true);
    }

    @Test
    void test2() {
        String pathName = Piece.class.getPackage().getName();
        Reflections reflections = new Reflections(pathName, Scanners.SubTypes);
        Set<Class<? extends Piece>> classes = reflections.getSubTypesOf(Piece.class);
        System.out.println("classes = " + classes);
    }

    @RecursiveInput
    public void inputSomething() {
        String inputText = "abcx";
        if (inputText.contains("x")) {
            throw new IllegalArgumentException("예외 발생");
        }
    }

    @Test
    void test3() {
        try {
            inputSomething();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    void test4() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = SampleInputTest.class.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("input")) {
                method.invoke(SampleInputTest.class);
            }
        }
    }

    @Test
    void test5() throws InvocationTargetException, IllegalAccessException {
        String pathName = SampleInput.class.getPackage().getName();
        Reflections reflections = new Reflections(pathName, Scanners.SubTypes);
        Set<Class<? extends Input>> classes = reflections.getSubTypesOf(Input.class);
//        Set<Method> methods = reflections.getMethodsAnnotatedWith(RecursiveInput.class);

        for (Class<? extends Input> aClass : classes) {
            for (Method method : aClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(RecursiveInput.class)) {
                    System.out.println(method.getName());
                    try {
                        method.invoke(SampleInput.class);
                    } catch (RuntimeException e) {
//                        System.err.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    void test6() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = SampleInput.class.getDeclaredMethods();
        for (Method method : methods) {
            method.invoke(SampleInput.class);
        }
    }
}
