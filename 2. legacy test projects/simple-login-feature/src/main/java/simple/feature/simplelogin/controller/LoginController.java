package simple.feature.simplelogin.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import simple.feature.simplelogin.domain.User;
import simple.feature.simplelogin.dto.LoginRequest;
import simple.feature.simplelogin.repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserRepository userRepository;

    @GetMapping("/login-form")
    public String loginForm() {

        return "/login-form.html";
    }

    @PostMapping("/login")
    public String hello(@RequestParam("name") String userName,
                        @RequestParam("password") String userPassword,
                        HttpServletRequest httpRequest,
                        HttpServletResponse httpResponse) {


        User findUser = userRepository.findByName(userName);

        if (notFoundUser(findUser)) {
            return "redirect:/error-login";
        }

        String realPassword = findUser.getPassword();
        String loginRequestPassword = userPassword;

        if (notMatchedPassword(realPassword, loginRequestPassword)) {
            return "redirect:/error-login";
        }

        // 로그인 성공 로직
        loginSuccessProcess(httpRequest, httpResponse, findUser);

        return "redirect:/item-detail";
    }

    @GetMapping("/error-login")
    public String errorLogin() {

        return "/error-not-registered-user.html";
    }

    private static void loginSuccessProcess(HttpServletRequest httpRequest, HttpServletResponse httpResponse, User findUser) {

        Cookie cookie = new Cookie("client_cookie", findUser.getId().toString());
        httpResponse.addCookie(cookie);
        HttpSession session = httpRequest.getSession();
        session.setAttribute("server_session", findUser);
    }

    private static boolean notFoundUser(User findUser) {
        return findUser == null;
    }

    private static boolean notMatchedPassword(String realPassword, String loginRequestPassword) {
        return !realPassword.equals(loginRequestPassword);
    }

}
