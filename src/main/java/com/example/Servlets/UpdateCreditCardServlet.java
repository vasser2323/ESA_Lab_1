package com.example.Servlets;

import com.example.Beans.CreditCardBean;
import com.example.Beans.CustomerBean;
import com.example.modules.CreditCard;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateCreditCard")
public class UpdateCreditCardServlet extends HttpServlet {
    @EJB
    private CreditCardBean creditCardBean;
    @EJB
    private CustomerBean customerBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer cardId = Integer.parseInt(request.getParameter("cardId"));
        CreditCard updatedCreditCard = creditCardBean.findCreditCardById(cardId);

        updatedCreditCard.setCardNumber(request.getParameter("card_number"));
        updatedCreditCard.setCardHolderName(request.getParameter("card_holder_name"));
        updatedCreditCard.setExpirationDate(request.getParameter("expiration_date"));
        updatedCreditCard.setCvv(request.getParameter("cvv"));
        updatedCreditCard.setCustomer(customerBean.findCustomerById(Integer.parseInt("customerId")));

        creditCardBean.updateCreditCard(updatedCreditCard);

        request.setAttribute("actionNameInf", "Update");
        request.setAttribute("actionNamePast", "updated");
        request.setAttribute("name", "creditcard");
        request.setAttribute("returnLink", "creditcards");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
