package org.L02.servlets;

import org.L02.utils.LongLivedCookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/table-cookies")
public class TableCookiesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Cookie testCookie = new Cookie("testCookie", "testValue");
        testCookie.setMaxAge(60*60*24); // 1 day
        response.addCookie(testCookie);

        Cookie anotherCookie = new Cookie("anotherCookie", "anotherValue");
        anotherCookie.setMaxAge(60*60*24*7); // 1 week
        response.addCookie(anotherCookie);

        HttpSession session = request.getSession();
        session.setAttribute("favDrink", "Tea");
        session.setAttribute("favFood", "Pizza");

        PrintWriter out = response.getWriter();

        out.println(session.getId());

        out.println("<table border='1'>");
        out.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");

        out.println("<tr><td><b>Test Cookie</b></td><td>" + testCookie.getValue() + "</td></tr>");
        out.println("<tr><td><b>Another Cookie</b></td><td>" + anotherCookie.getValue() + "</td></tr>");

        out.println("<tr><td><b>Session</b> -> favDrink</td><td>" + session.getAttribute("favDrink") + "</td></tr>");
        out.println("<tr><td><b>Session</b> -> favFood</td><td>" + session.getAttribute("favFood") + "</td></tr>");

        out.println("</table>");

    }
}
