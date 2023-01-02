package skeleton.code.spring.error.handle.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String param = request.getParameter("interceptor-param");
        if (param != null && param.contains("ex")) {
            throw new RuntimeException("ErrorInterceptor.preHandle");
        }
        return true;
    }
}
