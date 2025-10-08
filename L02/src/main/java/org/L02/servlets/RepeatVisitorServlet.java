package org.L02.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="repeatVisitorServlet", value="/repeat-cookie")
public class RepeatVisitorServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean newbie = true;
        Cookie[] cookies = request.getCookies();

        if(cookies != null){
            for(Cookie c : cookies){
                if((c.getName().equals("repeatVisitor")) &&
                        (c.getValue().equals("yes"))
                ) {
                    newbie = false;
                    break;
                }
            }
        }

        String title;
        if(newbie){
            Cookie returnVisitorCookie = new Cookie("repeatVisitor", "yes");
            returnVisitorCookie.setMaxAge(60* 2);
            response.addCookie(returnVisitorCookie);
            title = "Welcome first time!";
        } else {
            title = "Welcome back!";
        }

        PrintWriter out = response.getWriter();
        out.println(title);
    }
}
