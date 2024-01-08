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
import java.util.List;

@WebServlet("/customers")
public class CustomerServlet extends HttpServlet {
    @EJB
    private CustomerBean customerBean; 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerBean.getAllCustomers(); 

        request.setAttribute("customerList", customerList); 

        request.getRequestDispatcher("/customers.jsp").forward(request, response); 
    }
}
