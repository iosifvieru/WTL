package org.L02.servlets;

import jdk.internal.org.jline.utils.OSUtils;
import org.L02.utils.TextSanitizer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/profile-servlet")
public class ProfileServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        // sanitize inputs
        firstName = TextSanitizer.sanitize(firstName);
        lastName = TextSanitizer.sanitize(lastName);
        email = TextSanitizer.sanitize(email);

        HttpSession session = request.getSession();
        session.setAttribute("errorMessage", null);

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);
        session.setAttribute("email", email);

        if(firstName == null || firstName.trim().isEmpty()) {
            session.setAttribute("errorMessage", "First name is required");
        } else if(lastName == null || lastName.trim().isEmpty()) {
            session.setAttribute("errorMessage", "Last name is required");
        } else if(email == null || email.trim().isEmpty()) {
            session.setAttribute("errorMessage", "Email is required");
        } else if(!email.contains("@")) {
            session.setAttribute("errorMessage", "Email must be valid");
        }

        if(session.getAttribute("errorMessage") != null) {
            response.sendRedirect("index.jsp");
            return;
        }

        // out
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        out.println("<h2>Your Profile</h2>");
        out.println("<p>First Name: " + firstName + "</p>");
        out.println("<p>Last Name: " + lastName + "</p>");
        out.println("<p>Email: " + email + "</p>");

        out.println("</body></html>");
        out.close();

    }
}
