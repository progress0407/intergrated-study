package simple.feature.simplelogin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class OrderController {

    @PostMapping("/order")
    public String createOrder(HttpServletRequest request) {

        return "order 생성 화면이에요.";
    }
}
