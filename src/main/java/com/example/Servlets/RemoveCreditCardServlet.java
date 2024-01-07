package com.example.Servlets;

import com.example.Beans.CreditCardBean;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeCreditCard")
public class RemoveCreditCardServlet extends HttpServlet {
    @EJB
    private CreditCardBean creditCardBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer cardId = Integer.parseInt(request.getParameter("id"));
        creditCardBean.removeCreditCard(cardId);

        request.setAttribute("actionNameInf", "Remove");
        request.setAttribute("actionNamePast", "removed");
        request.setAttribute("name", "Credit Card");
        request.setAttribute("returnLink", "creditcards");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
