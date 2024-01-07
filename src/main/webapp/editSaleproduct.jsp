<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.Saleproduct" %>
<%@ page import="com.example.modules.Product" %>
<%@ page import="com.example.modules.Sale" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Saleproduct</title>
</head>
<body>

<h2>Edit Saleproduct</h2>

<form action="updateSaleproduct" method="post">

    <input type="hidden" name="saleProductId" value="${saleproduct.saleProductId}">

    <br>

    <label for="productId">Product ID:</label>
    <input type="text" id="productId" name="productId" value="${product.productId}">

    <br>

    <label for="saleId">Sale ID:</label>
    <input type="text" id="saleId" name="saleId" value="${sale.saleId}">

    <br>

    <label for="quantity">Quantity:</label>
    <input type="text" id="quantity" name="quantity" value="${saleproduct.quantity}">

    <input type="submit" value="Save">
</form>

<a href="removeSaleproduct?id=${saleproduct.saleProductId}">Remove</a>
<a href="sales">Back to Sale List</a>
</body>
</html>
