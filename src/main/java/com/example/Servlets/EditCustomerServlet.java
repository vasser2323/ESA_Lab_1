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

@WebServlet("/editCustomer")
public class EditCustomerServlet extends HttpServlet {
    @EJB
    private CustomerBean customerBean; 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer customerId = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerBean.findCustomerById(customerId); 

        request.setAttribute("customer", customer); 

        request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);
    }
}
