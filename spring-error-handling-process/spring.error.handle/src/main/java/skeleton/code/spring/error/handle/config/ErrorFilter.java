package skeleton.code.spring.error.handle.config;

import javax.servlet.*;
import java.io.IOException;

public class ErrorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String filterParam = request.getParameter("filter-param");
        if (filterParam != null && filterParam.contains("ex")) {
            throw new RuntimeException("filter-ex");
        }
        chain.doFilter(request, response);
    }
}
