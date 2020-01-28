package am.basicweb.controller;


import com.mysql.cj.Session;
import com.mysql.cj.protocol.x.Notice;
import com.sun.mail.iap.Response;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationfFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpSession ses = request.getSession();
        request.getSession();
        if (ses.getAttribute("name")==null){
            HttpServletResponse response= (HttpServletResponse) servletResponse;
            response.sendRedirect("/index.jsp");
        }
        else{
            filterChain.doFilter(request,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
