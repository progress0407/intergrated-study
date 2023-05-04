package test.grammer.annotation.intInjection;

public class Target {
  @InjectionNumber(data = 1234) int a;
  int b = 123000;
  String  c;
}
