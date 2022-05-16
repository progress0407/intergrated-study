package clonecoding.toby.spring;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class WebApiCaller {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
//        List users = restTemplate.getForObject("http://localhost:8080", List.class);
        List<SimpleWebApp.User> users = restTemplate.exchange("http://localhost:8080",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SimpleWebApp.User>>() {
                }).getBody();
        users.forEach(System.out::println);
    }
}
