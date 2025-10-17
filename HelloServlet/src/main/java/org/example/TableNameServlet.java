package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "tableServlet", value = "/table-servlet")
public class TableNameServlet extends HttpServlet {
    public void init() {
    }

    public void destroy() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");

        PrintWriter out = response.getWriter();

        if (name == null || name.trim().isEmpty() || lastname == null || lastname.trim().isEmpty()) {
            response.setStatus(422);
            out.println("Parameters cannot be null.");
            return;
        }

        out.println("<html><head><title>Tabel</title></head><body>");
        out.println("<table border='1'>");
        out.println("<tr><th>Name</th><th>Lastname</th></tr>");
        out.println("<tr><td>" + name + "</td><td>" + lastname + "</td></tr>");
        out.println("</table>");
        out.println("</body></html>");

    }
}
