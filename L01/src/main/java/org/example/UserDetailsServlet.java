package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="userDetailsServlet", value="/user-details-servlet")
public class UserDetailsServlet extends HttpServlet {
    public void init() {}
    public void destroy() {}

    public String handleError(String errorMessage){
        return "<html><head><title>Error</title></head><body><h1>" + errorMessage + "</h1></body></html>";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        if(firstName == null || firstName.trim().isEmpty()){
            response.setStatus(422);
            out.println(handleError("First name cannot be null or empty."));
            return;
        }

        String lastName = request.getParameter("lastName");
        if(lastName == null || lastName.trim().isEmpty()){
            response.setStatus(422);
            out.println(handleError("Last name cannot be null or empty."));
            return;
        }

        String email = request.getParameter("email");
        if(email == null || email.trim().isEmpty()){
            response.setStatus(422);
            out.println(handleError("Email cannot be null or empty."));
            return;
        }

        // sanitizing inputs
        firstName = Utils.sanitize(firstName);
        lastName = Utils.sanitize(lastName);
        email = Utils.sanitize(email);

        out.println("<html><head><title>User Details</title></head><body>");
        out.println("<h1>User Details</h1>");
        out.println("<p>First Name: " + firstName + "</p>");
        out.println("<p>Last Name: " + lastName + "</p>");
        out.println("<p>Email: " + email + "</p>");

        out.println("</body></html>");
    }
}
