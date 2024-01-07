<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.Sale" %>
<%@ page import="com.example.modules.PaymentMethod" %>
<%@ page import="com.example.modules.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Sale</title>
</head>
<body>

<h2>Edit Sale</h2>

<form action="updateSale" method="post">

    <input type="hidden" name="saleId" value="${sale.saleId}">

    <br>

    <label for="customerId">CustomerID:</label>
    <input type="text" id="customerId" name="customerId" value="${customer.customerId}">

    <br>

    <label for="methodId">methodId:</label>
    <input type="text" id="methodId" name="methodId" value="${paymentMethod.methodId}">

    <br>

    <label for="amount">Amount:</label>
    <input type="text" id="amount" name="amount" value="${sale.amount}">

    <br>

    <label for="saleDate">sale Date:</label>
    <input type="text" id="saleDate" name="saleDate" value="${sale.saleDate}">

    <input type="submit" value="Save">
</form>

<a href="removeSale?id=${sale.saleId}">Remove</a>
<a href="sales">Back to Sale List</a>
</body>
</html>
