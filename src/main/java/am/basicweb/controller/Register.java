package am.basicweb.controller;

import am.basicweb.model.User;
import am.basicweb.repository.UserRepository;
import am.basicweb.repository.UserRepositoryImpl;
import am.basicweb.repository.UserRepositoryImplJdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Register extends HttpServlet {
    private UserRepository userRepositor = new UserRepositoryImpl();
    private UserRepository userRepositor1 = new UserRepositoryImpl();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        int age=0;
        if (request.getParameter("age")!=null  && !request.getParameter("age").isEmpty()) {
             age = Integer.parseInt(request.getParameter("age"));
        }
        String code = request.getParameter("code");
        try {
            User user = new User();
            User duplicate= userRepositor.gUsername(username);
            if (duplicate!=null){
                request.setAttribute("jog","That user already created ");
            }
            else {
                if (surname == null || surname.isEmpty() || password == null || password.isEmpty() || name == null || name.isEmpty() || username == null || username.isEmpty() || code == null || code.isEmpty()) {
        /*        PrintWriter printWriter1 = response.getWriter();
                printWriter1.println("error");*/
                    request.setAttribute("jog", "Registration is wrong");
                    request.getRequestDispatcher("/Register.jsp").forward(request, response);
                } else {
                    // User user = new User();
                    user.setAge(age);
                    user.setCode(code);
                    user.setName(name);
                    user.setPassword(password);
                    user.setSurname(surname);
                    user.setUsername(username);
                    userRepositor1.addUser(user);
                    response.sendRedirect("/home.html");

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        //////////////////////////////////////
    }
