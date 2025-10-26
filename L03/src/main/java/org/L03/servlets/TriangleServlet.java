package org.L03.servlets;

import org.L03.beans.TriangleBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/triangle")
public class TriangleServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int sideA = Integer.parseInt(request.getParameter("a"));
            int sideB = Integer.parseInt(request.getParameter("b"));
            int sideC = Integer.parseInt(request.getParameter("c"));

            TriangleBean triangle = new TriangleBean(sideA, sideB, sideC);

            // if not triangle then return with message.
            if(!triangle.isTriangle()) {
                request.setAttribute("formError", "Laturile nu formeaza un triunghi");

                // forward to index.jsp with error.
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // if triangle, calculate area and perimeter.
            double triangleArea = triangle.calculateArea();
            double trianglePerimeter = triangle.calculatePerimeter();

            String message = String.format("Aria perimetrului: %f; Perimetrul triunghiului: %f", triangleArea, trianglePerimeter);

            request.setAttribute("formMessage", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException e){
            request.setAttribute("formError", "Laturile nu sunt numere intregi.");

            // forward to index.jsp with formError.
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
