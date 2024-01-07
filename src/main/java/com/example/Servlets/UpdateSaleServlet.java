package com.example.Servlets;

import com.example.Beans.CustomerBean;
import com.example.Beans.PaymentMethodBean;
import com.example.Beans.SaleBean;
import com.example.modules.Sale;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateSale")
public class UpdateSaleServlet extends HttpServlet {
    @EJB
    private SaleBean saleBean;
    @EJB
    private PaymentMethodBean paymentMethodBean;
    @EJB
    private CustomerBean customerBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer saleId = Integer.parseInt(request.getParameter("saleId"));
        Sale updatedSale = saleBean.findSaleById(saleId);

        updatedSale.setAmount(Double.parseDouble(request.getParameter("amount")));
        updatedSale.setSaleDate(request.getParameter("saleDate"));
        updatedSale.setPaymentMethod(paymentMethodBean.findPaymentMethodById(Integer.parseInt(request.getParameter("methodId"))));
        updatedSale.setCustomer(customerBean.findCustomerById(Integer.parseInt(request.getParameter("customerId"))));

        saleBean.updateSale(updatedSale);

        request.setAttribute("actionNameInf", "Update");
        request.setAttribute("actionNamePast", "updated");
        request.setAttribute("name", "Sale");
        request.setAttribute("returnLink", "sales");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
