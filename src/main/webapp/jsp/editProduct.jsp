<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/11/2020
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
    <title>Edit product</title>

    <a href="/products">return to product list</a>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <form method="post">
        <fieldset>
            <legend>product information</legend>
        <label for="id">Id:</label><br>
        <input type="text" id="id" name="id" value="${requestScope["product"].getId()}"><br>

        <label for="productName">Product Name:</label><br>
        <input type="text" id="productName" name="productName" value="${requestScope["product"].getProductName()}"><br>

        <label for="productDescription">Description:</label><br>
        <input type="text" id="productDescription" name="productDescription" value="${requestScope["product"].getProductDescription()}"><br><br>

        <label for="category">Category:</label><br>
        <input type="text" id="category" name="category" value="${requestScope["product"].getCategory()}"><br><br>

        <label for="quantity">Quantity:</label><br>
        <input type="text" id="quantity" name="quantity" value="${requestScope["product"].getQuantity()}"><br><br>

        <label for="image">Image:</label><br>
        <input type="text" id="image" name="image" value="${requestScope["product"].getImage()}"><br><br>
        <input type="submit" value="update product">
        </fieldset>
    </form>
</body>
</html>
