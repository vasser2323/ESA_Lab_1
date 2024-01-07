package com.example.Servlets;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.Beans.ProductBean; // Исправлен импорт на ProductBean
import com.example.modules.Product; // Исправлен импорт на Product

@WebServlet("/editProduct") // Изменен URL на /editProduct
public class EditProductServlet extends HttpServlet {

    @EJB
    private ProductBean productBean; // Измененная ссылка на ProductBean

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("id"));
        Product product = productBean.findProductById(productId); // Измененный метод

        request.setAttribute("product", product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editProduct.jsp"); // Измененный путь
        dispatcher.forward(request, response);
    }
}
