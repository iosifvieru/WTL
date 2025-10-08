package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "parametersExerciseServlet", value = "/parameters-servlet")
public class ParametersExerciseServlet extends HttpServlet {
    public void init(){}
    public void destroy() {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

//         referer
        String referer = request.getHeader("Referer");
        if(referer == null || !referer.endsWith("/HelloServlet/")){
            response.sendRedirect("http://localhost:8080/HelloServlet");
            return;
        }

        String firstParam = request.getParameter("param1");
        if(firstParam == null || firstParam.trim().isEmpty()){
            response.setStatus(422);
            out.println("Parameters cannot be null.");
            return;
        }

        String secondParam = request.getParameter("param2");
        if(secondParam == null || secondParam.trim().isEmpty()){
            response.setStatus(422);
            out.println("Parameters cannot be null.");
            return;
        }

        String thirdParam = request.getParameter("param3");
        if(thirdParam == null || thirdParam.trim().isEmpty()){
            response.setStatus(422);
            out.println("Parameters cannot be null.");
            return;
        }

        out.println("<html><body>");
        out.println("<p> Primul parametru: " + firstParam + "</p>");
        out.println("<p> Al doilea parametru: " + secondParam + "</p>");
        out.println("<p> Al treilea parametru: " + thirdParam + " </p>");
        out.println("</body></html>");
    }

}
