package com.example.Servlets;

import java.io.IOException;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.Beans.PaymentMethodBean;

import com.example.modules.PaymentMethod;

@WebServlet("/paymentmethods") 
public class PaymentMethodServlet extends HttpServlet { 
    @EJB
    private PaymentMethodBean paymentMethodBean; 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PaymentMethod> paymentMethodsList = paymentMethodBean.getAllPaymentMethods(); 

        request.setAttribute("paymentMethodsList", paymentMethodsList); 

        RequestDispatcher dispatcher = request.getRequestDispatcher("/paymentmethods.jsp");
        dispatcher.forward(request, response);
    }
}
