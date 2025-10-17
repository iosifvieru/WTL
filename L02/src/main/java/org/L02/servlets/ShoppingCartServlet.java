package org.L02.servlets;

import org.L02.models.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value="/add-to-cart")
public class ShoppingCartServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        // retrieve list from session
        ArrayList<Product> list;
        if(session.getAttribute("shopping-cart") != null){
            list = (ArrayList<Product>) session.getAttribute("shopping-cart");
        } else {
            list = new ArrayList<>();
        }

        // get product name
        String productName = request.getParameter("productName");

        if(productName == null || productName.trim().isEmpty()){
            session.setAttribute("shoppingCartError", "Product name cannot be null.");
            response.sendRedirect("index.jsp");
            return;
        }

        boolean exists = checkIfProductExists(list, productName);
        if(!exists){
            // add product to list
            list.add(new Product(productName, 1));
        } else {
            // increase product quantity
            for(Product p: list) {
                if (p.getProductName().equals(productName)) {
                    p.setQuantity(p.getQuantity() + 1);
                    break;
                }
            }
        }

        session.setAttribute("shopping-cart", list);
        response.sendRedirect("index.jsp");
    }

    private boolean checkIfProductExists(ArrayList<Product> list, String productName){
        for(Product p : list){
            if(p.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }
}
