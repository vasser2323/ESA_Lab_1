package com.example.Servlets;

import com.example.Beans.CustomerBean;
import com.example.modules.Customer; 

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateCustomer")
public class UpdateCustomerServlet extends HttpServlet {
    @EJB
    private CustomerBean customerBean; 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = Integer.parseInt(request.getParameter("customer_id"));
        Customer updatedCustomer = customerBean.findCustomerById(customerId);

        updatedCustomer.setCustomerName(request.getParameter("customer_name"));
        updatedCustomer.setEmail(request.getParameter("email"));
        updatedCustomer.setPhoneNumber(request.getParameter("phone_number"));
        updatedCustomer.setAddress(request.getParameter("address"));

        customerBean.updateCustomer(updatedCustomer);

        request.setAttribute("actionNameInf", "Update");
        request.setAttribute("actionNamePast", "updated");
        request.setAttribute("name", "Customer");
        request.setAttribute("returnLink", "customers"); 

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
