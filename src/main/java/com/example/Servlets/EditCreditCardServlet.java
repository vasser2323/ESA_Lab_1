package com.example.Servlets;


import com.example.Beans.CreditCardBean;
import com.example.Beans.CustomerBean;
import com.example.modules.CreditCard;
import com.example.modules.Customer;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editCreditCard")
public class EditCreditCardServlet extends HttpServlet {
    @EJB
    private CreditCardBean creditCardBean;
    @EJB
    private CustomerBean customerBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer cardId = Integer.parseInt(request.getParameter("id"));
        CreditCard creditCard = creditCardBean.findCreditCardById(cardId);
        List<Customer> allCustomers = customerBean.getAllCustomers();

        request.setAttribute("creditCard", creditCard);
        request.setAttribute("allCustomers", allCustomers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editCreditCard.jsp");
        dispatcher.forward(request, response);
    }
}
