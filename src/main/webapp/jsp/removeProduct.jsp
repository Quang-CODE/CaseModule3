<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/11/2020
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Deleting product</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>product information</legend>
        <table>
            <label for="id">Id:</label><br>
            <input type="text" id="id" name="id" value="${requestScope["product"].getId()}"><br>

            <label for="productName">Product Name:</label><br>
            <input type="text" id="productName" name="productName" value="${requestScope["product"].getProductName()}"><br>

            <label for="productDescription">Description:</label><br>
            <input type="text" id="productDescription" name="productDescription" value="${requestScope["product"].getProductDescription()}"><br><br>

            <label for="category">Category:</label><br>
            <input type="text" id="category" name="category" value="${requestScope["product"].getCategory()}"><br><br>

            <label for="quantity">quantity:</label><br>
            <input type="text" id="quantity" name="quantity" value="${requestScope["product"].getQuantity()}"><br><br>

            <label for="Image">Image:</label><br>
            <input type="text" id="Image" name="Image" value="${requestScope["product"].getImage()}"><br><br>
            <input type="submit" value="remove product">
        </table>
    </fieldset>
</form>
</body>
</html>
