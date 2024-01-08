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
        int customerId = -1;

        try {
            customerId = Integer.parseInt(idStr); 
        } catch (NumberFormatException e) {

        }

        Customer newCustomer = new Customer();
        newCustomer.setCustomerId(customerId); 

        newCustomer.setCustomerName(request.getParameter("customer_name"));
        newCustomer.setEmail(request.getParameter("email"));
        newCustomer.setPhoneNumber(request.getParameter("phone_number"));
        newCustomer.setAddress(request.getParameter("address"));

        customerBean.addCustomer(newCustomer); 

        response.sendRedirect(request.getContextPath() + "/customers"); 
    }
}
