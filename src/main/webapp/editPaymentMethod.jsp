<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.PaymentMethod" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Payment Method</title>
</head>
<body>

<h2>Edit Payment Method</h2>

<form action="updatePaymentMethod" method="post">
    <input type="hidden" name="methodId" value="${paymentMethod.methodId}">

    <label for="methodName">Method Name:</label>
    <input type="text" id="methodName" name="methodName" value="${paymentMethod.methodName}">

    <br>

    <input type="submit" value="Save">
</form>

<a href="removePaymentMethod?id=${paymentMethod.methodId}">Remove</a>
<a href="paymentmethods">Back to Payment Method List</a>
</body>
</html>