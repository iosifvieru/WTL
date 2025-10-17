package org.L02.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="cookiesServlet", value="/cookies")
public class CookiesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        out.println("<h3>Your cookies: </h3>");

        Cookie[] cookies = request.getCookies();
        if(cookies == null) {
            out.println("<TR><TH COLSPAN=2>No cookies.");
        } else {
            for(Cookie cookie: cookies) {
                out.println
                        ("<BR/><TR>" +
                                " <TD>" + cookie.getName() + ": " +
                                " <TD>" + cookie.getValue());
            }
        }
    }

}
