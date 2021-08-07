package test.grammer.reflection;

import static java.lang.System.*;

import java.lang.reflect.Field;

public class ReflectionUser {

  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    Class<?> clazz = RefObject.class;

    out.println("clazz.getCanonicalName() = " + clazz.getCanonicalName());
    out.println("clazz.getDeclaredFields() = " + clazz.getDeclaredFields());

    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      out.println("field.getName() = " + field.getName());
    }

    Field field = clazz.getDeclaredField("numId");

    RefObject refObject = new RefObject();

    field.setAccessible(true);
    int numId = (int) field.get(refObject);
    out.println("numId = " + numId);

    field.set(refObject, 3);
    numId = (int) field.get(refObject);
    out.println("numId = " + numId);
    
  }

}
