package com.example.Servlets;

import com.example.Beans.CustomerBean; // Подставьте правильное имя вашего бина для работы с клиентами
import com.example.modules.Customer; // Подставьте правильное имя вашего класса сущности Customer

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customers")
public class CustomerServlet extends HttpServlet {
    @EJB
    private CustomerBean customerBean; // Подставьте правильное имя вашего бина для работы с клиентами

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerBean.getAllCustomers(); // Получаем список всех клиентов из базы данных

        request.setAttribute("customerList", customerList); // Устанавливаем атрибут для передачи списка клиентов в JSP

        request.getRequestDispatcher("/customers.jsp").forward(request, response); // Перенаправляем запрос к JSP странице
    }
}
