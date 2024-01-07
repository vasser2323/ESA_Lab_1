package com.example.Servlets;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.Beans.PaymentMethodBean;
import com.example.modules.PaymentMethod;


@WebServlet("/editPaymentMethod")
public class EditPaymentMethodServlet extends HttpServlet {
    @EJB
    private PaymentMethodBean paymentMethodBean; 


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer methodId = Integer.parseInt(request.getParameter("id"));
        PaymentMethod paymentMethod = paymentMethodBean.findPaymentMethodById(methodId);

        request.setAttribute("paymentMethod", paymentMethod);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/editPaymentMethod.jsp");
        dispatcher.forward(request, response);
    }
}