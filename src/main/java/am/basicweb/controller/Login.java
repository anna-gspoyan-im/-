package am.basicweb.controller;

import am.basicweb.model.User;
import am.basicweb.repository.UserRepository;
import am.basicweb.repository.UserRepositoryImpl;
import am.basicweb.repository.UserRepositoryImplJdbc;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Login extends HttpServlet {
    private  UserRepository userRepositor = new UserRepositoryImpl();
    private UserRepository userRepositor1 = new UserRepositoryImpl();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        PrintWriter printWriter = response.getWriter();
      try {
           User user = (User) userRepositor.getbyUserNameAndPassword(username,password);
            if(user!=null){
                Cookie cookie= new Cookie("username",user.getUsername());
                cookie.setMaxAge(36000000);
                response.addCookie(cookie);
                session.setAttribute("name",user);
                response.sendRedirect("/secure/test.html");
            }
            else
            {
                request.setAttribute("abcd","username or password is wrong");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
              /*  PrintWriter printWriter1=response.getWriter();
                printWriter1.println("Exit");*/
            }
        } catch (SQLException e) {
          e.printStackTrace();
      }
    }
}
