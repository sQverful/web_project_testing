//package epam.testing_app.webControllers.filter;
//
//import epam.testing_app.Path;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/admin/*")
//public class JspAccessFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // nothing
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
//        httpResponse.sendRedirect(httpRequest.getContextPath() + Path.PAGE_LOGIN);
//    }
//
//    @Override
//    public void destroy() {
//        // nothing
//    }
//}
