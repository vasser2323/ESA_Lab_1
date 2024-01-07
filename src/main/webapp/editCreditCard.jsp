<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.CreditCard" %>
<%@ page import="com.example.modules.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Credit Card</title>
</head>
<body>

<h2>Edit Credit Card</h2>

<form action="updateCreditCard" method="post">
    <input type="hidden" name="cardId" value="${creditCard.cardId}">

    <br>

    <label for="customerId">CustomerID:</label>
    <input type="text" id="customerId" name="customerId" value="${customer.customerId}">

    <br>

    <label for="card_number">Card Number:</label>
    <input type="text" id="card_number" name="card_number" value="${creditCard.cardNumber}">

    <br>

    <label for="card_holder_name">Card Holder Name:</label>
    <input type="text" id="card_holder_name" name="card_holder_name" value="${creditCard.cardHolderName}">

    <br>

    <label for="expiration_date">Expiration Date:</label>
    <input type="date" id="expiration_date" name="expiration_date" value="${creditCard.expirationDate}">

    <br>

    <label for="cvv">CVV:</label>
    <input type="text" id="cvv" name="cvv" value="${creditCard.cvv}">

    <br>

    <input type="submit" value="Save">
</form>

<a href="removeCreditCard?id=${creditCard.cardId}">Remove</a>
<a href="creditcards">Back to Credit Card List</a>
</body>
</html>
