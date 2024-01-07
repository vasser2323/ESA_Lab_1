package com.example.Servlets;

import com.example.Beans.CustomerBean;
import com.example.modules.Customer;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCustomer")
public class AddCustomerServlet extends HttpServlet {
    @EJB
    private CustomerBean customerBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("customer_id");
        int customerId = -1; // Значение по умолчанию, если ID не указан или указан некорректно

        try {
            customerId = Integer.parseInt(idStr); // Попытка преобразования строки в число
        } catch (NumberFormatException e) {
            // В случае некорректного ввода ID или его отсутствия будет использоваться значение по умолчанию (-1)
            // Можно добавить обработку ошибки или вывести сообщение об ошибке в логи
        }

        Customer newCustomer = new Customer();
        newCustomer.setCustomerId(customerId); // Установка ID для нового клиента

        // Получаем остальные данные о клиенте из запроса и устанавливаем их в новый экземпляр клиента
        newCustomer.setCustomerName(request.getParameter("customer_name"));
        newCustomer.setEmail(request.getParameter("email"));
        newCustomer.setPhoneNumber(request.getParameter("phone_number"));
        newCustomer.setAddress(request.getParameter("address"));

        customerBean.addCustomer(newCustomer); // Добавляем клиента через бин

        response.sendRedirect(request.getContextPath() + "/customers"); // Перенаправляем на страницу с клиентами
    }
}
