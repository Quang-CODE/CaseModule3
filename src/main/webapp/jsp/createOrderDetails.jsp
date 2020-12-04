<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/11/2020
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <title>Title</title>
</head>

<html>
<head>
    <title>create new order details</title>
    <style>
        .message{
            color:green;
        }
    </style>
</head>
<body>
<%@include file="/jsp/header.jsp" %>
<div class="container" style="background-color: lavenderblush">
    <div id="form" style="height: 800px;align-content: center">
    <h1 style="text-align: center">Create new order details</h1>
    <p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
    </p>
    <p>
     <a style="text-align: center" href="/orderDetails">back to order details list</a>
    </p>
    <form action="/createOrderDetails" method="post">
        <legend>Create order details</legend>
        <table>
<%--            <tr>--%>
<%--                <td>Id: </td>--%>
<%--                <td><input type="number" name="id" id="id"></td>--%>
<%--            </tr>--%>
            <tr>
                <td>Order id: </td>
                <td><input type="number" name="orderId" id="orderId"></td>
            </tr>
            <tr>
                <td>Product id: </td>
                <td><input type="number" name="productId" id="productId"></td>
            </tr>
            <tr>
                <td>Order number: </td>
                <td><input type="number" name="orderNumber" id="orderNumber"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="number" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Quantity </td>
                <td><input type="number" name="quantity" id="quantity"></td>
            </tr>
            <tr>
                <td>Ship address: </td>
                <td><input type="text" name="shipAddress" id="shipAddress"></td>
            </tr>

            <td></td>
            <td><input type="submit" value="Create order details"></td>
            </tr>
        </table>
</form>
    </div>
</div>
<%@include file="/jsp/footer.jsp" %>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

</html>
