package com.example.Servlets;

import com.example.Beans.SaleproductBean; 

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeSaleproduct") 
public class RemoveSaleproductServlet extends HttpServlet {

    @EJB
    private SaleproductBean saleproductBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer saleProductId = Integer.parseInt(request.getParameter("id")); 
        saleproductBean.removeSaleProduct(saleProductId); 

        request.setAttribute("actionNameInf", "Remove");
        request.setAttribute("actionNamePast", "removed");
        request.setAttribute("name", "Saleproduct"); 
        request.setAttribute("returnLink", "saleproducts"); 

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
