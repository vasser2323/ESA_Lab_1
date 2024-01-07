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

@WebServlet("/paymentmethods") // Changed the servlet URL mapping to /paymentMethods
public class PaymentMethodServlet extends HttpServlet { // Renamed to PaymentMethodServlet
    @EJB
    private PaymentMethodBean paymentMethodBean; // Renamed LexiconBean to PaymentMethodBean

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PaymentMethod> paymentMethodsList = paymentMethodBean.getAllPaymentMethods(); // Changed method name to getAllPaymentMethods

        request.setAttribute("paymentMethodsList", paymentMethodsList); // Changed attribute name to paymentMethodsList

        RequestDispatcher dispatcher = request.getRequestDispatcher("/paymentmethods.jsp"); // Changed JSP page to paymentMethods.jsp
        dispatcher.forward(request, response);
    }
}