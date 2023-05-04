package spring.argument.resolver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
class UserController {

    @PostMapping
    public UserResponse userPost(@RequestBody User user) {
        return UserResponse.from(user);
    }

    @GetMapping
    public UserResponse userGet() {
        return new UserResponse("philz@foo.com", "swcho");
    }

    @PostMapping("/model-attribute/v1")
    public String postUserModelAttributeV1(@ModelAttribute UserModelAttributeV1 userModelAttribute) {
        return userModelAttribute + " 가 생성되었습니다.";
    }

    @PostMapping("/model-attribute/v2")
    public String postUserModelAttributeV2(@ModelAttribute UserModelAttributeV2 userModelAttribute) {
        return userModelAttribute + " 가 생성되었습니다.";
    }

    @GetMapping("/model-attribute")
    public String userModelGet() {
        return "경로가 /model 인 문자열 반환.";
    }

    @PostMapping("/request-body")
    public String postUserRequestBody(@RequestBody UserRequestBody userRequestBody) {
//        throw new RuntimeException("error !");
        return userRequestBody + " 가 생성되었습니다.";
    }
}
