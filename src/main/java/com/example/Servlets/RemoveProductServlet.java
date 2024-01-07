package com.example.Servlets;

import com.example.Beans.ProductBean; // Исправлен импорт на ProductBean

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeProduct") // Изменен URL на /removeProduct
public class RemoveProductServlet extends HttpServlet {

    @EJB
    private ProductBean productBean; // Измененная ссылка на ProductBean

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = Integer.parseInt(request.getParameter("id"));
        productBean.removeProduct(productId); // Измененный метод

        request.setAttribute("actionNameInf", "Remove");
        request.setAttribute("actionNamePast", "removed");
        request.setAttribute("name", "Product"); // Измененное имя
        request.setAttribute("returnLink", "products"); // Измененный URL для перенаправления

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
