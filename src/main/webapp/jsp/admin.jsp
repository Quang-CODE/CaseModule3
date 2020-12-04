<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 12/3/2020
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Admin</title>
</head>
<body>
<%@include file="/jsp/header.jsp" %>
<div class="container" style="background-color: lavenderblush">
    <div id="form" style="height: 800px;align-content: center">
        <h1 style="text-align: center">WELCOME TO ADMIN PAGE</h1>
        <div class="container-fluid">
            <table class="table table-striped">
                <thead class="thead-dark">
                <tr>
                    <th scope="col-4">Information</th>
                    <th scope="col">Link</th>
                </tr>
                </thead>
                <tr>
                    <td>Users: </td>
                    <td><a href="/users">Click here to get infomations</a> </td>
                </tr>
                <tr>
                    <td>Orders: </td>
                    <td><a href="/order">Click here to get infomations</a> </td>
                </tr>
                <tr>
                    <td>Order details: </td>
                    <td><a href="/orderDetails">Click here to get infomations</a> </td>
                </tr>
                <tr>
                    <td>Products: </td>
                    <td><a href="">Click here to get infomations</a> </td>
                </tr>

            </table>

        </div>
    </div>
</div>

<%@include file="/jsp/footer.jsp" %>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</html>
