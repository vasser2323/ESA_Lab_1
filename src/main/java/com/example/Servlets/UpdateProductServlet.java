package com.example.Servlets;

import com.example.Beans.ProductBean; // Исправлен импорт на ProductBean
import com.example.modules.Product; // Исправлен импорт на Product

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateProduct") // Изменен URL на /updateProduct
public class UpdateProductServlet extends HttpServlet {

    @EJB
    private ProductBean productBean; // Измененная ссылка на ProductBean

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Product updatedProduct = productBean.findProductById(productId); // Измененный метод

        updatedProduct.setProductName(request.getParameter("productName")); // Измененный метод
        updatedProduct.setPrice(Double.parseDouble(request.getParameter("price"))); // Измененный метод
        updatedProduct.setStockQuantity(Integer.parseInt(request.getParameter("stockQuantity"))); // Измененный метод

        productBean.updateProduct(updatedProduct); // Измененный метод

        request.setAttribute("actionNameInf", "Update");
        request.setAttribute("actionNamePast", "updated");
        request.setAttribute("name", "Product");
        request.setAttribute("returnLink", "products");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
