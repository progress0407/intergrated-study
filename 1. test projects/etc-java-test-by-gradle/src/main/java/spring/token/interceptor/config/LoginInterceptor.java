package spring.token.interceptor.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import spring.token.interceptor.utils.AuthorizationExtractor;
import spring.token.interceptor.utils.CurrentDateTimeProvider;
import spring.token.interceptor.utils.JwtTokenUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 토큰 기반 로그인 인터셉터
 */
public class LoginInterceptor implements HandlerInterceptor {

    public static final String INVALID_TOKEN_MESSAGE = "유효하지 않는 토큰이에요";
    private ObjectMapper objectMapper = new ObjectMapper();
    private JwtTokenUtils jwtTokenUtils = new JwtTokenUtils(new CurrentDateTimeProvider());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = AuthorizationExtractor.extract(request);
        String payload = null;
        try {
            payload = jwtTokenUtils.restorePayload(token);
        } catch (MalformedJwtException e) {
            /**
             * 유효하지 않은 토큰
             */
            sendUnAuthorizedError(response);
            return false;
        } catch (SignatureException e) {
            sendUnAuthorizedError(response);
            return false;
        } catch (Exception e) {
            sendUnAuthorizedError(response);
            return false;
        }
        return true;
    }

    private void sendUnAuthorizedError(HttpServletResponse response) throws IOException {
        int unAuthVal = HttpStatus.UNAUTHORIZED.value();
        response.setStatus(unAuthVal);
        String json = objectMapper.writeValueAsString(new ErrorResult(unAuthVal, INVALID_TOKEN_MESSAGE));
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(json);
    }

//    private void sendUnAuthorized

   @Data
   @AllArgsConstructor
    private static class ErrorResult {
        private int statusCode;
        private String message;
    }
}
