package org.L02.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/show-session")
public class ShowSessionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        String heading;

        Integer accessCount;
        synchronized (session) {
            accessCount = (Integer) session.getAttribute("accessCount");

            if(accessCount == null){
                accessCount = 0;
                heading = "Welcome, Newcomer";
            } else {
                heading = "Welcome Back";
                accessCount = accessCount + 1;
            }
            session.setAttribute("accessCount", accessCount);
        }

        PrintWriter out = response.getWriter();
        out.println(heading);
        out.print("<br>Number of accesses to this page: " + accessCount);
        out.close();
    }
}
