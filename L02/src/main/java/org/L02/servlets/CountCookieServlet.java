package org.L02.servlets;

import org.L02.utils.CookieUtilities;
import org.L02.utils.LongLivedCookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/count-cookie")
public class CountCookieServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String countString = CookieUtilities.getCookieValue(request, "accessCount", "0");
        int count = 0;
        try {
            count = Integer.parseInt(countString);
        } catch(NumberFormatException nfe) {
            System.out.println(nfe);
        }

        count = count + 1;
        LongLivedCookie c = new LongLivedCookie("accessCount", String.valueOf(count));
        response.addCookie(c);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Access count: " + count);
    }
}
