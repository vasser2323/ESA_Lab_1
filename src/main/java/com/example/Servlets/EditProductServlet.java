package com.example.Servlets;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.Beans.ProductBean; 
import com.example.modules.Product;

@WebServlet("/editProduct") 
public class EditProductServlet extends HttpServlet {

    @EJB
    private ProductBean productBean; 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("id"));
        Product product = productBean.findProductById(productId); 

        request.setAttribute("product", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editProduct.jsp"); 
        dispatcher.forward(request, response);
    }
}
