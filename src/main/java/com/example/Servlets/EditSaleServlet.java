package com.example.Servlets;

import com.example.Beans.CustomerBean;
import com.example.Beans.PaymentMethodBean;
import com.example.Beans.SaleBean;
import com.example.modules.Customer;
import com.example.modules.PaymentMethod;
import com.example.modules.Sale;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editSale")
public class EditSaleServlet extends HttpServlet {
    @EJB
    private SaleBean saleBean;
    @EJB
    private PaymentMethodBean paymentMethodBean;
    @EJB
    private CustomerBean customerBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer saleId = Integer.parseInt(request.getParameter("id"));
        Sale sale = saleBean.findSaleById(saleId);
        List<PaymentMethod> allPaymentMethods = paymentMethodBean.getAllPaymentMethods();
        List<Customer>allCustomers = customerBean.getAllCustomers();

        request.setAttribute("sale", sale);
        request.setAttribute("allPaymentMethods", allPaymentMethods);
        request.setAttribute("allCustomers", allCustomers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editSale.jsp");
        dispatcher.forward(request, response);
    }
}
