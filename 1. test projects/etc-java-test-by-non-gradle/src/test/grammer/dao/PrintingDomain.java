package test.grammer.dao;

import java.util.Arrays;

public class PrintingDomain {
    void print() {
        SubDomain sd = new SubDomain();
        Arrays.stream(sd.getClass().getDeclaredFields()).iterator().forEachRemaining(field -> System.out.println("field = " + field.getName()));
        System.out.println("sd.name = " + sd.name);
        System.out.println("sd.name = " + sd.phomeNumber1);
    }
}

