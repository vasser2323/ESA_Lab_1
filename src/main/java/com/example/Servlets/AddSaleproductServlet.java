package com.example.Servlets;

import com.example.Beans.ProductBean;
import com.example.Beans.SaleBean; 
import com.example.Beans.SaleproductBean; 
import com.example.modules.Saleproduct; 

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addSaleproduct") 
public class AddSaleproductServlet extends HttpServlet {

    @EJB
    private SaleproductBean saleproductBean;
    @EJB
    private ProductBean productBean; 
    @EJB 
    private SaleBean saleBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Saleproduct newSaleproduct = new Saleproduct(); 

        newSaleproduct.setQuantity(Integer.parseInt(request.getParameter("quantity")));
    
        newSaleproduct.setProduct(productBean.findProductById(Integer.parseInt(request.getParameter("productId"))));
        newSaleproduct.setSale(saleBean.findSaleById(Integer.parseInt(request.getParameter("saleId"))));  

        saleproductBean.addSaleProduct(newSaleproduct); 

        response.sendRedirect(request.getContextPath() + "/saleproducts"); 
    }
}
