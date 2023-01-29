package test.grammer.annotation.strInjection;

import java.lang.reflect.Field;

public class Main {
  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException{

    Target target = new Target();
    Field[] fields = target.getClass().getDeclaredFields();

    for (Field field : fields) {
      if(field.getType() == String.class && field.isAnnotationPresent(Trim.class)) {
//        field.setAccessible(true);
        String fieldValue = (String) field.get(target);
        field.set(target, fieldValue.trim());
      }
    }

    System.out.println("target.a = " + target.a);
    System.out.println("target.b = " + target.b);
  }
}
