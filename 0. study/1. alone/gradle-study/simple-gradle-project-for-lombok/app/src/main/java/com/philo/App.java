/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.philo;

import lombok.Getter;

@Getter
public class App {

    private final String message = "Hello World!2";

    public String getGreeting() {
        return message;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.getGreeting());
        System.out.println("app.getMessage() = " + app.getMessage());
    }
}