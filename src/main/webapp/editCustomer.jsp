<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>

<h2>Edit Customer</h2>

<form action="updateCustomer" method="post">


    <label for="customer_name">Customer Name:</label>
    <input type="text" id="customer_name" name="customer_name" value="">
    <br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" value="${customer.email}">

    <br>

    <label for="phone_number">Phone Number:</label>
    <input type="text" id="phone_number" name="phone_number" value="${customer.phoneNumber}">

    <br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="${customer.address}">

    <br>

    <input type="submit" value="Save">
</form>

<a href="removeCustomer?id=${customer.customerId}">Remove</a>
<a href="customers">Back to Customer List</a>
</body>
</html>
