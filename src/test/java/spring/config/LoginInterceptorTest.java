package spring.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import spring.test.TestUser;
import spring.utils.CurrentDateTimeProvider;
import spring.utils.JwtTokenUtils;

import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static spring.utils.AuthorizationExtractor.AUTHORIZATION;

class LoginInterceptorTest {

    public static final TypeReference<LinkedHashMap<String, String>> TYPE_REF = new TypeReference<>() {
    };
    LoginInterceptor loginInterceptor = new LoginInterceptor();
    ObjectMapper objectMapper = new ObjectMapper();

    JwtTokenUtils jwtTokenUtils = new JwtTokenUtils(new CurrentDateTimeProvider());

    @DisplayName("토큰을 가지고 있지 않을 경우 로그인을 허가하지 않는다")
    @Test
    void t1() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        Object handler = new Object();
        boolean result = loginInterceptor.preHandle(request, response, handler);
        assertThat(result).isFalse();
    }

    @DisplayName("정상적인 토큰을 가지고 있을 경우 로그인을 허가한다")
    @Test
    void t2() throws Exception {
        String token = jwtTokenUtils.createToken(TestUser.ID);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader(AUTHORIZATION, "Bearer "+ token);
        MockHttpServletResponse response = new MockHttpServletResponse();
        Object handler = new Object();
        boolean result = loginInterceptor.preHandle(request, response, handler);
        assertThat(result).isTrue();
    }

    @DisplayName("의도적으로 조작된 토큰의 경우 접근을 불허하고 에러 정보가 담긴 JSON 객체를 반환한다")
    @Test
    void t3() throws Exception {
        // given
        String 의도적으로_조작한_토큰 = jwtTokenUtils.createToken(TestUser.ID) + "something do this token";
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader(AUTHORIZATION, "Bearer "+ 의도적으로_조작한_토큰);
        MockHttpServletResponse response = new MockHttpServletResponse();
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        Object handler = new Object();

        // when
        boolean result = loginInterceptor.preHandle(request, response, handler);
        String message = objectMapper.readValue(response.getContentAsString(), TYPE_REF).get("message");

        // then
        assertThat(result).isFalse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.UNAUTHORIZED.value());
        assertThat(message).isEqualTo(LoginInterceptor.INVALID_TOKEN_MESSAGE);
    }
}
