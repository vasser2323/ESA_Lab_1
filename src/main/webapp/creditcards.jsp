<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.CreditCard" %>
<%@ page import="com.example.modules.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Credit Card List</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>Credit Card List</h2>

<form action="addCreditCard" method="post">


    <label for="card_number">Card Number:</label>
    <input type="text" id="card_number" name="card_number" value="" required>

    <br>

    <label for="customerId">Card Holder Name:</label>
    <input type="text" id="customerId" name="customerId" value="${customer.customerId}">

    <br>

    <label for="expiration_date">Expiration Date:</label>
    <input type="text" id="expiration_date" name="expiration_date" value="" required>

    <br>

    <label for="cvv">CVV:</label>
    <input type="text" id="cvv" name="cvv" value="" required>

    <br>

    <input type="submit" value="Add">
</form>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Card Number</th>
        <th>Card Holder Name (customerId)</th>
        <th>Expiration Date</th>
        <th>CVV</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="creditCard" items="${creditCardList}">
        <tr>
            <td>${creditCard.cardId}</td>
            <td>${creditCard.cardNumber}</td>
            <td>${creditCard.customer.customerName}</td>
            <td>${creditCard.expirationDate}</td>
            <td>${creditCard.cvv}</td>
            <td><a href="editCreditCard?id=${creditCard.cardId}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
