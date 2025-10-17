package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="codeServlet", value="/code-servlet")
public class CodeServlet extends HttpServlet {
    public void init(){}
    public void destroy(){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        String code = request.getParameter("code");
        if(code == null || code.trim().isEmpty()) {
            response.setStatus(422);
            out.println("Code parameter cannot be null.");
            return;
        }

        // sanitize the code
        code = Utils.sanitize(code);

        out.println("<html><head><title>Code</title></head><body><pre><code>");

        // code content
        out.println(code);

        out.println("</code></pre></body></html>");
    }
}
