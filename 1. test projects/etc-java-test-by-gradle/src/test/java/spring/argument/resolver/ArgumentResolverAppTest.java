package spring.argument.resolver;

import static java.lang.System.out;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

class ArgumentResolverAppTest {

    private static final String URL = "http://localhost:8081/users";
    private static final String USER_EMAIL = "philz@foo.com";
    private static final String USER_NAME = "swcho";
    private static final String USER_PASSWORD = "1234";

    RestTemplate restTemplate = new RestTemplate();
    User user;

    ArgumentResolverAppTest() {
        user = new User("philz@foo.com", "swcho", "1234");
//        user = new User();
//        user.setEmail("philz@foo.com");
//        user.setName("swcho");
//        user.setPassword("1234");
    }


    @DisplayName("post user : obj")
    @Test
    void _1() {
        UserResponse userResponseEntity =
                restTemplate.postForObject(URL, user, UserResponse.class);

        out.println("userResponseEntity = " + userResponseEntity);
    }

    @DisplayName("get user : http")
    @Test
    void _3() {
        ResponseEntity<UserResponse> userResponseResponseEntity =
                restTemplate.getForEntity(URL, UserResponse.class);

        out.println("userResponseResponseEntity = " + userResponseResponseEntity);
    }

    @DisplayName("get ModelAttribute")
    @Test
    void _5() {
        String response = restTemplate.getForObject(URL + "/model-attribute", String.class);
        out.println("response = " + response);
    }

    @DisplayName("POST ModelAttribute ")
    @Nested
    class Post_ModelAttribute {

        HttpEntity<MultiValueMap<String, String>> request;

        Post_ModelAttribute() {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("email", USER_EMAIL);
            body.add("name", USER_NAME);
            body.add("password", USER_PASSWORD);

            request = new HttpEntity<>(body, headers);
        }

        @DisplayName("- java beans")
        @Test
        void _1() {
            ResponseEntity<String> response =
                    restTemplate.postForEntity(URL + "/model-attribute/v1", request, String.class);

            out.println("response = " + response);
        }

        @DisplayName("- primary constructor")
        @Test
        void _2() {

            ResponseEntity<String> response = restTemplate.postForEntity(URL + "/model-attribute/v2",
                    request, String.class);

            out.println("response = " + response);
        }
    }

    @DisplayName("POST RequestBody")
    @Nested
    class Post_RequestBody {

        HttpEntity<MultiValueMap<String, String>> request;
        HttpHeaders headers = new HttpHeaders();

        Post_RequestBody() {
            headers.setContentType(MediaType.APPLICATION_JSON);

            LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("email", USER_EMAIL);
            body.add("name", USER_NAME);
            body.add("password", USER_PASSWORD);

            request = new HttpEntity<>(body, headers);
        }

        @DisplayName("- java beans - multiValueMap")
        @Test
        void _1() {
            ResponseEntity<String> response = restTemplate.postForEntity(URL + "/request-body", request,
                    String.class);

            out.println("response = " + response);
        }

        @DisplayName("- java beans - DTO")
        @Test
        void _2() {
            UserRequestBody dto = new UserRequestBody();
            dto.setEmail(USER_EMAIL);
            dto.setName(USER_NAME);
            dto.setPassword(USER_PASSWORD);

            ResponseEntity<String> response = restTemplate.postForEntity(URL + "/request-body", request,
                    String.class);

            out.println("response = " + response);
        }

        @DisplayName("test")
        @Test
        void tt() {
            UserRequestBody dto = new UserRequestBody();
            dto.setEmail(USER_EMAIL);
            dto.setName(USER_NAME);
            dto.setPassword(USER_PASSWORD);

            HttpEntity<UserRequestBody> request = new HttpEntity<>(dto, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    URL + "/request-body",
                    HttpMethod.POST,
                    request,
                    String.class
            );

            out.println("response = " + response);
        }

        @DisplayName("test2")
        @Test
        void ttt() throws JSONException {
            JSONObject json = new JSONObject();
            json.put("email", USER_EMAIL);
            json.put("name", USER_NAME);
            json.put("password", USER_PASSWORD);

            String body = json.toString();
            HttpEntity<String> request = new HttpEntity<>(body, headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    URL + "/request-body",
                    HttpMethod.POST,
                    request,
                    String.class
            );

            out.println("response = " + response);
        }
    }
}
