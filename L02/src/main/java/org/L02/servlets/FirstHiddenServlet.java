package org.L02.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/first-hidden")
public class FirstHiddenServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            String n = request.getParameter("userName");

            out.print("Welcome " + n);
            out.print("<form action='second-hidden' method=post>");
            out.print("<input type='hidden' name='userName' value='" + n + "'>");
            out.print("<input type='submit' value='go'>");
            out.print("</form>");

            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
