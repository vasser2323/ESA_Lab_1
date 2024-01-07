package com.example.Servlets;

import com.example.modules.CreditCard;
import com.example.Beans.CreditCardBean;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/creditcards")
public class CreditCardServlet extends HttpServlet {
    @EJB
    private CreditCardBean creditCardBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CreditCard> creditCardList = creditCardBean.getAllCreditCards();
        request.setAttribute("creditCardList", creditCardList);
        
        request.getRequestDispatcher("/creditcards.jsp").forward(request, response);
    }
}

