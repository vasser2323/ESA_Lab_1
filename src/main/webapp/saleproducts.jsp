<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.Saleproduct" %>
<%@ page import="com.example.modules.Product" %>
<%@ page import="com.example.modules.Sale" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Saleproduct List</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>Saleproduct List</h2>

<form action="addSaleproduct" method="post">

    <input type="hidden" name="saleProductId" value="">

    <br>

    <label for="productId">Product ID:</label>
    <input type="text" id="productId" name="productId" value="${product.productId}">

    <br>

    <label for="saleId">Sale ID:</label>
    <input type="text" id="saleId" name="saleId" value="${sale.saleId}">

    <br>

    <label for="quantity">Quantity:</label>
    <input type="text" id="quantity" name="quantity" value="">

    <input type="submit" value="Add">
</form>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Amount</th>
        <th>Quantity</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="saleproduct" items="${saleproductList}">
        <tr>
            <td>${saleproduct.saleProductId}</td>
            <td>${saleproduct.product.productName}</td>
            <td>${saleproduct.sale.amount}</td>
            <td>${saleproduct.quantity}</td>
            <td><a href="editSaleproduct?id=${saleproduct.saleProductId}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
