package com.example.Servlets;

import com.example.Beans.PaymentMethodBean;
import com.example.modules.PaymentMethod;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePaymentMethod") 
public class UpdatePaymentMethodServlet extends HttpServlet { 
    @EJB
    private PaymentMethodBean paymentMethodBean; 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer methodId = Integer.parseInt(request.getParameter("methodId")); 
        PaymentMethod updatedPaymentMethod = paymentMethodBean.findPaymentMethodById(methodId);

        updatedPaymentMethod.setMethodName(request.getParameter("methodName")); 

        paymentMethodBean.updatePaymentMethod(updatedPaymentMethod);
        request.setAttribute("actionNameInf", "Update");
        request.setAttribute("actionNamePast", "updated");
        request.setAttribute("name", "Payment Method");
        request.setAttribute("returnLink", "paymentmethods"); 

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}