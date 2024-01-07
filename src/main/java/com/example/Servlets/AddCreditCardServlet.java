package com.example.Servlets;

import com.example.Beans.CreditCardBean;
import com.example.Beans.CustomerBean;
import com.example.modules.CreditCard;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addCreditCard")
public class AddCreditCardServlet extends HttpServlet {
    @EJB
    private CreditCardBean creditCardBean;
    @EJB
    private CustomerBean customerBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreditCard newCreditCard = new CreditCard();

        newCreditCard.setCardNumber(request.getParameter("card_number"));
        newCreditCard.setCardHolderName(request.getParameter("card_holder_name"));
        newCreditCard.setExpirationDate(request.getParameter("expiration_date"));
        newCreditCard.setCustomer(customerBean.findCustomerById(Integer.parseInt(request.getParameter("customerId"))));
        newCreditCard.setCvv(request.getParameter("cvv"));

        creditCardBean.addCreditCard(newCreditCard);

        response.sendRedirect(request.getContextPath() + "/creditcards");
    }
}
