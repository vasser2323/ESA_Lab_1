package com.example.Servlets;

import com.example.Beans.ProductBean; // Исправлен импорт на ProductBean
import com.example.modules.Product; // Исправлен импорт на Product

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProduct") // Изменен URL на /addProduct
public class AddProductServlet extends HttpServlet {

    @EJB
    private ProductBean productBean; // Измененная ссылка на ProductBean

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product newProduct = new Product(); // Измененный объект на Product

        newProduct.setProductName(request.getParameter("product_name")); // Измененный метод
        newProduct.setPrice(Double.parseDouble(request.getParameter("price"))); // Измененный метод
        newProduct.setStockQuantity(Integer.parseInt(request.getParameter("stock_quantity"))); // Измененный метод

        productBean.addProduct(newProduct); // Измененный метод

        response.sendRedirect(request.getContextPath() + "/products"); // Измененный URL для перенаправления
    }
}
