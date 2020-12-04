<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/11/2020
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>create new product</title>
        <style>
            .message{
                color:green;
            }
        </style>
    </head>
    <body>
    <h1>Create new product</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <a href="/products">back to product list</a>

    </p>

    <form method="post">
        <fieldset>
            <legend>product info</legend>
            <table>


                <label for="productName">Product Name:</label><br>
                <input type="text" id="productName" name="productName" ><br>

                <label for="productDescription">Description:</label><br>
                <input type="text" id="productDescription" name="productDescription" ><br><br>

                <label for="category">Category:</label><br>
                <input type="text" id="category" name="category" ><br><br>

                <label for="quantity">Quantity:</label><br>
                <input type="text" id="quantity" name="quantity" ><br><br>

                <label for="image">Image:</label><br>
                <input type="text" id="image" name="image" ><br><br>

                <label for="price">Price:</label><br>
                <input type="text" id="price" name="price" ><br>

                <input type="submit" value="update product">
            </table>
        </fieldset>
    </form>
    </body>
</html>

</body>
</html>
