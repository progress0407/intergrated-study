package test.grammer.annotation.strInjection;

public class Target {
  @Trim public String a = "Hello"; // 일반 문자열
  @Trim public String b = "   Hello "; // 공백이 있는 문자열
  public String c; // 아무 값이 없는 문자열
}
