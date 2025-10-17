package org.L03.servlets;

import org.L03.beans.Course;
import org.L03.beans.Instructor;
import org.L03.beans.Subject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BeanPropsServlet", value="/bean-props")
public class BeanPropsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Instructor instructor = new Instructor("Cristian", "Aflori");
        Subject subject = new Subject("WTL", "Web Technologies and Languages");

        Course course = new Course(instructor, subject);

        request.setAttribute("course", course);

        RequestDispatcher dispatcher = request.getRequestDispatcher("bean-props.jsp");
        dispatcher.forward(request, response);
    }
}
