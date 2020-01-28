package am.basicweb.controller;

import am.basicweb.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Info extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie [] cookies=request.getCookies();
        for (Cookie cookie:cookies){
            System.out.println(cookie.getName()+" "+cookie.getValue());
        }
        HttpSession ses = request.getSession();
        User user = (User) ses.getAttribute("name");

        PrintWriter printWriter= response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<body>");
        printWriter.println("<H1>");
        printWriter.println("<I>");
        printWriter.println("name="+user.getName());
        printWriter.println("surname="+user.getSurname());
        printWriter.println("age="+user.getAge());
        printWriter.println("</I>");
        printWriter.println("</H1");
        printWriter.println("/html");
    }
}