package com.example.demo.Servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.demo.Repositories.CreditCardRepository;
import com.example.demo.models.CreditCard;
  
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    CreditCardRepository q = new CreditCardRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CreditCard tom = this.q.findAll().getFirst();
        // CreditCard tom = new CreditCard();
        request.setAttribute("credit_card", tom);
        getServletContext()
            .getRequestDispatcher("/CreditCard.jsp")
            .forward(request, response);
    }
}
