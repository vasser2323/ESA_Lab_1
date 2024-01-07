package com.example.Servlets;

import com.example.Beans.SaleBean;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeSale")
public class RemoveSaleServlet extends HttpServlet {
    @EJB
    private SaleBean saleBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer saleId = Integer.parseInt(request.getParameter("id"));
        saleBean.removeSale(saleId);

        request.setAttribute("actionNameInf", "Remove");
        request.setAttribute("actionNamePast", "removed");
        request.setAttribute("name", "Sale");
        request.setAttribute("returnLink", "sales");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
