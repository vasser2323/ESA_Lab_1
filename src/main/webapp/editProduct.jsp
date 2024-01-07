<%@ page import="java.util.List" %>
<%@ page import="com.example.modules.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>

<h2>Edit Product</h2>

<form action="updateProduct" method="post">
    <input type="hidden" name="productId" value="${product.productId}">

    <label for="productName">Product Name:</label>
    <input type="text" id="productName" name="productName" value="${product.productName}">

    <br>

    <label for="price">Price:</label>
    <input type="text" id="price" name="price" value="${product.price}">

    <br>

    <label for="stockQuantity">Stock Quantity:</label>
    <input type="text" id="stockQuantity" name="stockQuantity" value="${product.stockQuantity}">

    <br>

    <input type="submit" value="Save">
</form>

<a href="removeProduct?id=${product.productId}">Remove</a>
<a href="products">Back to Product List</a>
</body>
</html>
