package com.example.Servlets;

import com.example.Beans.ProductBean; 
import com.example.modules.Product; 

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProduct") 
public class AddProductServlet extends HttpServlet {

    @EJB
    private ProductBean productBean; 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product newProduct = new Product(); 

        newProduct.setProductName(request.getParameter("product_name"));
        newProduct.setPrice(Double.parseDouble(request.getParameter("price"))); 
        newProduct.setStockQuantity(Integer.parseInt(request.getParameter("stock_quantity"))); 

        productBean.addProduct(newProduct); 

        response.sendRedirect(request.getContextPath() + "/products"); 
    }
}
