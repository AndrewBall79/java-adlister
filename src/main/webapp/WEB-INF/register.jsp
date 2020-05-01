<%--
  Created by IntelliJ IDEA.
  User: AndrewBall
  Date: 5/1/20
  Time: 12:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Please Register</h1>
    <form action="/register" method="POST">
        <div class="form-group">
            <label for="username">Enter a Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="email">Enter a Email</label>
            <input id="email" name="email" class="form-control" type="email">
        </div>
        <div class="form-group">
            <label for="password">Enter a Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <div class="form-group">
            <label for="password">Confirm</label>
            <input id="confirm" name="confirm" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="Log In">
    </form>
</div>

</body>
</html>
