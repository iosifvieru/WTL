package org.L03.servlets;

import org.L03.beans.TriangleBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/triangle-ajax")
public class TriangleAjaxServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();

        String strA = request.getParameter("a");
        if(strA == null){
            out.println(jsonifyResponse(false, "a este null."));
            return;
        }

        String strB = request.getParameter("b");
        if(strB == null){
            out.println(jsonifyResponse(false, "b este null."));
            return;
        }

        String strC = request.getParameter("c");
        if(strC == null){
            out.println(jsonifyResponse(false, "c este null."));
            return;
        }

        try {
            int sideA = Integer.parseInt(strA);
            int sideB = Integer.parseInt(strB);
            int sideC = Integer.parseInt(strC);

            TriangleBean triangleBean = new TriangleBean(sideA, sideB, sideC);

            if(!triangleBean.isTriangle()){
                out.println(jsonifyResponse(false, "Laturile nu formeaza un triunghi."));
                return;
            }

            double triangleArea = triangleBean.calculateArea();
            double trianglePerimeter = triangleBean.calculatePerimeter();

            String message = String.format("Aria perimetrului: %f; Perimetrul triunghiului: %f", triangleArea, trianglePerimeter);

            out.println(jsonifyResponse(true, message));
            return;

        } catch (NumberFormatException e){
            System.out.println(e);
            out.println(jsonifyResponse(false, "Laturile triunghiului nu sunt numere intregi."));
        }
    }

    private String jsonifyResponse(boolean isOk, String errorMsg){
        return String.format("{\"ok\": %b, \"error\": \"%s\"}", isOk, errorMsg);
    }
}
