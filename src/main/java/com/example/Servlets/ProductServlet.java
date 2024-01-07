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
import java.util.List;

@WebServlet("/products") // Изменен URL на /products
public class ProductServlet extends HttpServlet {

    @EJB
    private ProductBean productBean; // Измененная ссылка на ProductBean

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productBean.getAllProducts(); // Измененный метод
        
        request.setAttribute("productList", productList); // Измененное имя атрибута
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/products.jsp"); // Измененный путь
        dispatcher.forward(request, response);
    }
}
