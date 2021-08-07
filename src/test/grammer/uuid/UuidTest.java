package test.grammer.uuid;

import java.util.UUID;

public class UuidTest {

  public static void main(String[] args) {
    UUID u1 = UUID.randomUUID();
    UUID u2 = UUID.randomUUID();

    System.out.println("u1 = " + u1);
    System.out.println("u1 = " + u2);
  }

}
