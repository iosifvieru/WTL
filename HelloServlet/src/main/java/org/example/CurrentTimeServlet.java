package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name="currentTimeServlet", value="/time-servlet")
public class CurrentTimeServlet extends HttpServlet {
    public void init(){}
    public void destroy() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        // get current time
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));;

        out.println("<p>" + time + "</p>");
    }
}
