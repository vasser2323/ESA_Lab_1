<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>Customer List</h2>

<form action="addCustomer" method="post">


    <br>

    <label for="customer_name">Customer Name:</label>
    <input type="text" id="customer_name" name="customer_name" value="">

    <br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" value="">

    <br>

    <label for="phone_number">Phone Number:</label>
    <input type="text" id="phone_number" name="phone_number" value="">

    <br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="">

    <br>

    <input type="submit" value="Add">
</form>


<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Customer Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.customerName}</td>
            <td>${customer.email}</td>
            <td>${customer.phoneNumber}</td>
            <td>${customer.address}</td>
            <td><a href="editCustomer?id=${customer.customerId}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
