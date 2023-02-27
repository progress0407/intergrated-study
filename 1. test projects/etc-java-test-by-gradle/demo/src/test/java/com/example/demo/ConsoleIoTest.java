package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ConsoleIoTest {

    @Test
    void hello() {
        var outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        System.out.println("hello world");

        // after
        System.setOut(System.out);

        System.out.println("outContent = " + outContent);
    }
}
