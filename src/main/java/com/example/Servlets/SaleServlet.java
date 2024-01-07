package com.example.Servlets;

import com.example.Beans.SaleBean;
import com.example.modules.Sale;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/sales")
public class SaleServlet extends HttpServlet {
    @EJB
    private SaleBean saleBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sale> saleList = saleBean.getAllSales();

        request.setAttribute("saleList", saleList);

        request.getRequestDispatcher("sales.jsp").forward(request, response);
    }
}
