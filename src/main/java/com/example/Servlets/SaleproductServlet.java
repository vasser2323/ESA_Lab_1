package com.example.Servlets;

import com.example.Beans.SaleproductBean; 
import com.example.modules.Saleproduct; 

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/saleproducts") 
public class SaleproductServlet extends HttpServlet {

    @EJB
    private SaleproductBean saleproductBean; 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Saleproduct> saleproductList = saleproductBean.getAllSaleProducts(); 

        request.setAttribute("saleproductList", saleproductList);

        request.getRequestDispatcher("saleproducts.jsp").forward(request, response); 
    }
}
