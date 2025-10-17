package org.L03.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ScopedVarsServlet", value="/scoped-vars")
public class ScopedVarsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request attribute
        request.setAttribute("attribute1", "First Name");

        // session attribute
        HttpSession session = request.getSession();
        session.setAttribute("attribute2", "Second Value");

        //
        ServletContext application = getServletContext();
        application.setAttribute("attribute3", new java.util.Date());

        request.setAttribute("repeated", "Request");
        session.setAttribute("repeated", "Session");
        application.setAttribute("repeated", "ServletContext");

        // forward to jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("scoped-vars.jsp");
        dispatcher.forward(request, response);
    }
}
