package org.L02.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value="/change-session-colors")
public class ChangeBgAndTextServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String backgroundColor = request.getParameter("backgroundColor");
        String textColor = request.getParameter("textColor");

        if(backgroundColor == null || backgroundColor.trim().isEmpty()) {
            response.sendRedirect("change-colors.jsp");
            return;
        }

        if(textColor == null || textColor.trim().isEmpty()) {
            response.sendRedirect("change-colors.jsp");
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("backgroundColor", backgroundColor);
        session.setAttribute("textColor", textColor);

        response.sendRedirect("colored-page");
    }
}
