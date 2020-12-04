<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 12/2/2020
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <title>List Order</title>
</head>
<body>
<%@include file="/jsp/header.jsp" %>
<div class="container" style="background-color: lavenderblush">
    <div id="form" style="height: 800px;align-content: center">
        <h1 style="text-align: center">Order list</h1>
    <form action="/createOrder">
    <table class="table table-striped">
        <tr>
            <td><a href="/admin">Click here to go back to admin page</a></td>
        </tr>
        <tr>
            <td><a href="/jsp/createOrder.jsp">Create order</a></td>
        </tr>
        <tr>
            <th>Id</th>
            <th>User Id</th>
            <th>Total</th>
            <th>ACTIONS!!!</th>
        </tr>
        <c:forEach items="${orders}" var="order" >
            <tr>
                <td>${order.getId()}</td>
                <td>${order.getUserId()}</td>
                <td>${order.getTotal()}</td>
                <td>
                    <a href="/deleteOrder?id=${order.getId()}">Delete</a>
                    <a href="/editOrder?id=${order.getId()}">Edit</a>

                </td>
            </tr>
        </c:forEach>
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
