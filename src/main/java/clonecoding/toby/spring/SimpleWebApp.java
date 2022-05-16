package clonecoding.toby.spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class SimpleWebApp {

    public static void main(String[] args) {
        SpringApplication.run(SimpleWebApp.class, args);
    }

    @RestController
    static class MyController {

        @RequestMapping("/")
        public List<User> users() {
            return List.of(new User("A"), new User("B"), new User("C"));
        }

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @ToString
    static class User {
        private String name;
    }
}
