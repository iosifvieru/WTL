package org.L02.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(value = "/second-hidden")
public class SecondHiddenServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n=request.getParameter("userName");
            out.print("Hello "+n);
            out.close();

        }catch(Exception e){System.out.println(e);}
    }
}
