package am.basicweb.controller;

import com.sun.mail.iap.Response;
import org.w3c.dom.ls.LSOutput;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class Servlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("tbb");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("Barev dzez es responsenn em");
        printWriter.println("hello "+name);
    }
}
