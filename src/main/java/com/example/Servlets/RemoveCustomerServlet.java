package com.example.Servlets;

import com.example.Beans.CustomerBean; // Assuming there's a CustomerBean for CRUD operations on Customer entity

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeCustomer")
public class RemoveCustomerServlet extends HttpServlet {
    @EJB
    private CustomerBean customerBean; // Assuming this EJB manages Customer operations

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = Integer.parseInt(request.getParameter("id"));
        customerBean.removeCustomer(customerId);

        request.setAttribute("actionNameInf", "Remove");
        request.setAttribute("actionNamePast", "removed");
        request.setAttribute("name", "Customer");
        request.setAttribute("returnLink", "customers");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
