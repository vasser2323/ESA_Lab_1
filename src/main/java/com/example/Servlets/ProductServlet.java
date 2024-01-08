package com.example.Servlets;

import com.example.Beans.ProductBean; 
import com.example.modules.Product; 

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products") 
public class ProductServlet extends HttpServlet {

    @EJB
    private ProductBean productBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productBean.getAllProducts(); 
        
        request.setAttribute("productList", productList); 
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products.jsp"); 
        dispatcher.forward(request, response);
    }
}
