package com.example.Servlets;

import com.example.Beans.PaymentMethodBean;
import com.example.modules.PaymentMethod;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addPaymentMethod")
public class AddPaymentMethodServlet extends HttpServlet { 
    @EJB
    private PaymentMethodBean paymentMethodBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaymentMethod newPaymentMethod = new PaymentMethod(); 

        newPaymentMethod.setMethodName(request.getParameter("methodName")); 
        paymentMethodBean.addPaymentMethod(newPaymentMethod); 

        response.sendRedirect(request.getContextPath() + "/paymentmethods"); 
    }
}