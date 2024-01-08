package com.example.Servlets;

import com.example.Beans.PaymentMethodBean;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removePaymentMethod") 
public class RemovePaymentMethodServlet extends HttpServlet { 
    @EJB
    private PaymentMethodBean paymentMethodBean; 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer methodId = Integer.parseInt(request.getParameter("id"));
        paymentMethodBean.removePaymentMethod(methodId); 

        request.setAttribute("actionNameInf", "Remove");
        request.setAttribute("actionNamePast", "removed");
        request.setAttribute("name", "Payment Method");
        request.setAttribute("returnLink", "paymentmethods"); 

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
