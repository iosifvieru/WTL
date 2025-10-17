package org.L02.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@WebServlet(value="/first-session")
public class FirstSessionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n = request.getParameter("userName");
            out.print("Welcome " + n);
            HttpSession session = request.getSession();

            session.setAttribute("uname", n);

            out.print("<a href='second-session'> visit second pace </a>");
            out.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
