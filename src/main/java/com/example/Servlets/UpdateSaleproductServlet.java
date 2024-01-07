package com.example.Servlets;

import com.example.Beans.ProductBean;
import com.example.Beans.SaleBean;
import com.example.Beans.SaleproductBean; 
import com.example.modules.Saleproduct; 

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateSaleproduct") 
public class UpdateSaleproductServlet extends HttpServlet {

    @EJB
    private SaleproductBean saleproductBean;
    @EJB
    private ProductBean productBean;
    @EJB
    private SaleBean saleBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer saleProductId = Integer.parseInt(request.getParameter("saleProductId")); 
        Saleproduct updatedSaleproduct = saleproductBean.findSaleProductById(saleProductId); 

        updatedSaleproduct.setQuantity(Integer.parseInt(request.getParameter("quantity"))); 
        updatedSaleproduct.setProduct(productBean.findProductById(Integer.parseInt(request.getParameter("productId"))));
        updatedSaleproduct.setSale(saleBean.findSaleById(Integer.parseInt(request.getParameter("saleId")))); 


        saleproductBean.updateSaleProduct(updatedSaleproduct); // Измените на updateSaleProduct

        request.setAttribute("actionNameInf", "Update");
        request.setAttribute("actionNamePast", "updated");
        request.setAttribute("name", "Saleproduct"); // Измените на Saleproduct
        request.setAttribute("returnLink", "saleproducts"); // Измените на saleproducts

        RequestDispatcher dispatcher = request.getRequestDispatcher("/actionSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
