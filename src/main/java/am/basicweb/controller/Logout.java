package am.basicweb.controller;

import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ServletLogout")
public class Logout extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ses =request.getSession();
        ses.invalidate();
        Cookie cookie= new Cookie("username","value");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.sendRedirect("/index.jsp");
    }
}
