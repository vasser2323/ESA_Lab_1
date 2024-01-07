<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.Sale" %>
<%@ page import="com.example.modules.PaymentMethod" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sale List</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>Sale List</h2>

<form action="addSale" method="post">

    <input type="hidden" name="saleId" value="">

    <br>

    <label for="customerId">CustomerID:</label>
    <input type="text" id="customerId" name="customerId" value="${customer.customerId}">

    <br>

    <label for="methodId">methodId:</label>
    <input type="text" id="methodId" name="methodId" value="${paymentMethod.methodId}">

    <br>

    <label for="amount">Amount:</label>
    <input type="text" id="amount" name="amount" value="">

    <br>

    <label for="saleDate">sale Date:</label>
    <input type="text" id="saleDate" name="saleDate" value="">

    <input type="submit" value="Add">
</form>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Customer name</th>  
        <th>Payment Method</th>     
        <th>Amount</th>
        <th>Sale Date</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sale" items="${saleList}">
        <tr>
            <td>${sale.saleId}</td>
            <td>${sale.customer.customerName}</td>
            <td>${sale.paymentMethod.methodName}</td>
            <td>${sale.amount}</td>
            <td>${sale.saleDate}</td>
            <td><a href="editSale?id=${sale.saleId}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
