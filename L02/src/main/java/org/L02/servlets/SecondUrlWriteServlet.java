package org.L02.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/second-urlwrite")
public class SecondUrlWriteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();

            String n = request.getParameter("uname");
            out.print("Hello " + n);
            out.close();

        } catch(Exception e){
            System.out.println(e);
        }
    }
}
