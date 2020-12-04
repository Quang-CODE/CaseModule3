<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 12/3/2020
  Time: 8:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <title>Delete order</title>
</head>
<body>
<%@include file="/jsp/header.jsp" %>
<div class="container" style="background-color: lavenderblush">
    <div id="form" style="height: 800px;align-content: center">
        <h1 style="text-align: center">Delete form</h1>
        <p>
            <a href="/order">Back to user list</a>
        </p>
    <form action="/deleteOrder" method="post">
        <legend>Are you sure you want to delete</legend>
        <label for="id">Id:</label><br>
        <input type="number" id="id" name="id" value="${requestScope["order"].getId()}" hidden><br>
        <label for="customerId">Customer Id:</label><br>
        <input type="number" id="customerId" name="customerId" value="${requestScope["order"].getCustomerId()}"><br>
        <label for="orderNumber">Order number:</label><br>
        <input type="number" id="orderNumber" name="orderNumber" value="${requestScope["order"].getOrderNumber()}"><br><br>
        <input type="submit" value="delete order">

    </form>
    </div>
</div>
<%@include file="/jsp/footer.jsp" %>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

</html>
