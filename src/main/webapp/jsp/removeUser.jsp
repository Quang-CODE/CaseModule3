<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/11/2020
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <title>Deleting user</title>
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
        <h1 style="text-align: center">Delete form</h1>
    <p>
    <a href="/users">Back to user list</a>
    </p>
    <form method="post">
        <legend>Are you sure you want to delete</legend>
        <label for="id">Id:</label><br>
        <input type="number" id="id" name="id" value="${requestScope["user"].getId()}" hidden><br>
        <label for="firstName">First Name:</label><br>
        <input type="text" id="firstName" name="firstName" value="${requestScope["user"].getFirstName()}"><br>
        <label for="lastName">Last Name:</label><br>
        <input type="text" id="lastName" name="lastName" value="${requestScope["user"].getLastName()}"><br><br>
        <label for="address">Address:</label><br>
        <input type="text" id="address" name="address" value="${requestScope["user"].getAddress()}"><br><br>
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email" value="${requestScope["user"].getEmail()}"><br><br>
        <label for="shipAddress">Ship Address:</label><br>
        <input type="text" id="shipAddress" name="shipAddress" value="${requestScope["user"].getShipAddress()}"><br><br>
        <label for="role">Role:</label><br>
        <input type="number" id="role" name="role" value="${requestScope["user"].getRole()}"><br>
        <input type="submit" value="delete user">

    </form>
    </div>
</div>
<%@include file="/jsp/footer.jsp" %>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

</html>