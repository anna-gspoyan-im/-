package am.basicweb.controller;

import am.basicweb.model.User;
import am.basicweb.repository.UserRepository;
import am.basicweb.repository.UserRepositoryImpl;
import am.basicweb.repository.UserRepositoryImplJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletStart")
public class Start extends HttpServlet {
    private UserRepository userRepositor =new UserRepositoryImpl();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getCookies() == null) {
            response.sendRedirect("/index.jsp");
        }
        String username = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
            }
        }
        if (username == null) {
            response.sendRedirect("/index.jsp");
        } else {

            try {
                User user = (User) userRepositor.getbyUserName(username);
                request.getSession().setAttribute("name",user);
                response.sendRedirect("/secure/test.html");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
