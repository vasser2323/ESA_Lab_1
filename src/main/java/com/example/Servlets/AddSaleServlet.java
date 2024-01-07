package com.example.Servlets;

import com.example.Beans.CustomerBean;
import com.example.Beans.PaymentMethodBean;
import com.example.Beans.SaleBean;
import com.example.modules.Sale;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addSale")
public class AddSaleServlet extends HttpServlet {
    @EJB
    private SaleBean saleBean;
    @EJB
    private PaymentMethodBean paymentMethodBean;
    @EJB
    private CustomerBean customerBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Sale newSale = new Sale();

        newSale.setAmount(Double.parseDouble(request.getParameter("amount")));
        newSale.setSaleDate((request.getParameter("saleDate")));
        newSale.setPaymentMethod(paymentMethodBean.findPaymentMethodById(Integer.parseInt(request.getParameter("methodId"))));
        newSale.setCustomer(customerBean.findCustomerById(Integer.parseInt(request.getParameter("customerId"))));

        saleBean.addSale(newSale);

        response.sendRedirect(request.getContextPath() + "/sales");
    }
}
