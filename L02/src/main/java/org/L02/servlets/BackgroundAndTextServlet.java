package org.L02.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/colored-page")
public class BackgroundAndTextServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        String backgroundColor = (String) session.getAttribute("backgroundColor");
        String textColor = (String) session.getAttribute("textColor");

        if(backgroundColor == null || backgroundColor.trim().isEmpty()) {
            backgroundColor = "red";
            session.setAttribute("backgroundColor", backgroundColor);
        }

        if(textColor == null || textColor.trim().isEmpty()) {
            textColor = "yellow";
            session.setAttribute("textColor", textColor);
        }

        out.println("<html>" +
                "<head>" +
                "<title>Pagina colorata!!</title>" +
                "<style>" +
                "body {background-color: " + backgroundColor + ";}" +
                "p {color: " + textColor + ";}" +
                "</style>" +
                "</head>");

        // body
        out.println("<body><p>TEXT COLORAT!</p></body>");

        out.println("<a href='change-colors.jsp'>apasa aici pentru a schimba culorile paginii. </a>");

        out.println("</html>");
    }
}
