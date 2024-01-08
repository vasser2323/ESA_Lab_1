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

@WebServlet("/updateProduct") 
public class UpdateProductServlet extends HttpServlet {

    @EJB
    private ProductBean productBean; 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Product updatedProduct = productBean.findProductById(productId); 

        updatedProduct.setProductName(request.getParameter("productName")); 
        updatedProduct.setPrice(Double.parseDouble(request.getParameter("price")));
        updatedProduct.setStockQuantity(Integer.parseInt(request.getParameter("stockQuantity"))); 

        productBean.updateProduct(updatedProduct);

        request.setAttribute("actionNameInf", "Update");
        request.setAttribute("actionNamePast", "updated");
        request.setAttribute("name", "Product");
        request.setAttribute("returnLink", "products");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
