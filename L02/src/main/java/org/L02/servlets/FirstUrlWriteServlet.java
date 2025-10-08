package org.L02.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/first-urlwrite")
public class FirstUrlWriteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n = request.getParameter("userName");
            out.print("Welcome" + n);

            out.print("<a href='second-urlwrite?uname="+n+"'> visit second page</a>");
            out.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
