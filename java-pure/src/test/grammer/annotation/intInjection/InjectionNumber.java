package test.grammer.annotation.intInjection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectionNumber {
  int data()  default -1;
}
