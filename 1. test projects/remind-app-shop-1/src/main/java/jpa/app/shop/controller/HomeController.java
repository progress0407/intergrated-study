package jpa.app.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String name() {
        log.info("home controller");
        return "home";
    }
}
