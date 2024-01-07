<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<h2>Product List</h2>

<form action="addProduct" method="post">
    <label for="product_name">Product Name:</label>
    <input type="text" id="product_name" name="product_name" value="">

    <br>

    <label for="price">Price:</label>
    <input type="text" id="price" name="price" value="">

    <br>

    <label for="stockQuantity">Stock Quantity:</label>
    <input type="text" id="stock_quantity" name="stock_quantity" value="">

    <br>

    <input type="submit" value="Add">
</form>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Stock Quantity</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList}">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.stockQuantity}</td>
            <td><a href="editProduct?id=${product.productId}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
