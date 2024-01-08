package com.example.Servlets;

import com.example.Beans.ProductBean;
import com.example.Beans.SaleBean;
import com.example.Beans.SaleproductBean;
import com.example.modules.Product;
import com.example.modules.Sale;
import com.example.modules.Saleproduct; 

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/editSaleproduct") 
public class EditSaleproductServlet extends HttpServlet {

    @EJB
    private SaleproductBean saleproductBean;
    @EJB
    private SaleBean saleBean; 
    @EJB
    private ProductBean productBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer saleProductId = Integer.parseInt(request.getParameter("id")); 
        Saleproduct saleproduct = saleproductBean.findSaleProductById(saleProductId);
        List<Sale> allSales = saleBean.getAllSales();
        List<Product> allProducts = productBean.getAllProducts();

        request.setAttribute("saleproduct", saleproduct);

        request.setAttribute("allSales", allSales);
        request.setAttribute("allProducts", allProducts); 

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editSaleproduct.jsp"); 
        dispatcher.forward(request, response);
    }
}
