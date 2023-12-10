<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Java Bean Page</title>
</head>
<body>
<div>
<p>Name: ${credit_card.cardNumber}</p>
<p>Age: ${credit_card.expirationDate}</p>
</div>
</body>
</html>

 -->

 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Credit Card Details</title>
</head>
<body>
    <h3>Credit Card Details Received:</h3>
    <p>qweqwewqq  ${credit_card.cardNumber}</p>
    <p>ID: <%= request.getParameter("id") %></p>
    <p>Card Number: <%= request.getParameter("cardNumber") %></p>
    <p>Expiration Date: <%= request.getParameter("expirationDate") %></p>
    <p>CVV Code: <%= request.getParameter("cvvCode") %></p>
</body>
</html>
