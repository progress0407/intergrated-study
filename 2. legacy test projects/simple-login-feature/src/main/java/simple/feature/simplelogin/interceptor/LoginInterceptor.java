package simple.feature.simplelogin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import simple.feature.simplelogin.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User findUser = (User) session.getAttribute("server_session");

        if (findUser == null) { // login 안 된 경우
            response.sendRedirect("/login-form"); // 로그인 화면으로 리다이렉트
            return false;
        }
        else {
            return true;
        }
    }
}
