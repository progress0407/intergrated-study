package test.spring.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 체크메이트 앱 배포가 정상적으로 되었는 지를 테스트하기 위한 앱
 */

@RestController
public class TestApiController {

    @RequestMapping("/api/req")
    public String req() {
        return "/api/req";
    }
}
