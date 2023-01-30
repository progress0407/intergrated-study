package test.grammer.annotation.intInjection;

import java.lang.reflect.Field;

public class Main {
  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException{

    Target target = new Target();
    Field[] fields = target.getClass().getDeclaredFields();

    for (Field field : fields) {
      if(field.getType() == int.class && field.isAnnotationPresent(InjectionNumber.class)) {
        InjectionNumber anno = field.getAnnotation(InjectionNumber.class);
        int annoValue = anno.data();
        System.out.println("field.getInt = " + field.getInt(new Target()));
        field.set(target, annoValue);
      }
    }

    System.out.println("myHello.a = " + target.a);
    System.out.println("myHello.a = " + target.b);
  }
}
