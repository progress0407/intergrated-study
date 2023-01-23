package simple.feature.simplelogin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import simple.feature.simplelogin.domain.User;
import simple.feature.simplelogin.repository.UserRepository;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/signup-form")
    public String registerForm() {

        return "/signup-form.html";
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestParam("name") String userName,
                           @RequestParam("password") String userPassword) {

        userRepository.insert(new User(null, userName, userPassword));

        return "redirect:/login-form.html";
    }
}
