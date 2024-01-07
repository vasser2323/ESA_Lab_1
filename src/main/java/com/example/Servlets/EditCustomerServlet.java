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

@WebServlet("/editCustomer")
public class EditCustomerServlet extends HttpServlet {
    @EJB
    private CustomerBean customerBean; // Подставьте правильное имя вашего бина для работы с клиентами

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerBean.findCustomerById(customerId); // Получаем клиента по его ID

        request.setAttribute("customer", customer); // Устанавливаем атрибут для передачи клиента в JSP

        request.getRequestDispatcher("/editCustomer.jsp").forward(request, response); // Перенаправляем запрос к JSP странице
    }
}
