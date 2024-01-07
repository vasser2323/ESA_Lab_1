<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.PaymentMethod" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Payment Method List</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>Payment Method List</h2>

<form action="addPaymentMethod" method="post">

    <label for="methodName">Method Name:</label>
    <input type="text" id="methodName" name="methodName" value="">

    <br>

    <input type="submit" value="Add">
</form>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Method Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="paymentMethod" items="${paymentMethodsList}">
        <tr>
            <td>${paymentMethod.methodId}</td>
            <td>${paymentMethod.methodName}</td>
            <td><a href="editPaymentMethod?id=${paymentMethod.methodId}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>