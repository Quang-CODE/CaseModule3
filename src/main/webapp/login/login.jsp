<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 11/30/2020
  Time: 9:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
  <head>
    <title>Title</title>
      <!-- CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<%--      <link rel="stylesheet" href="login/login.css">--%>

  </head>
  <body>
  <%@include file="/jsp/header.jsp" %>

  <div class="container" style="background-color: lavenderblush">
    <div id="form" style="height: 650px;align-content: center" >
      <div class="container-fluid">
      <form style="align-content: center" method="post">
        <h1 style="text-align: center">Login</h1>
        <br>
        <p style="text-align: center">User name:  <input type="text" value="" name="user"></p>
        <p style="text-align: center">Password :   <input type="password" value="" name="password"></p>
        <div class="container-fluid" style="text-align: center">
          <button type="submit">Login</button>
          <br>
          <a href="/registerNewUser">Create account</a>
        </div>
      </form>
      </div>
    </div>
  </div>
  <%@include file="/jsp/footer.jsp" %>

  </body>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</html>
