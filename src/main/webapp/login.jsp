<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
<%-- form to get email and password --%>
<form method="POST" action="/login.jsp">
        <label for="Username">Username:</label>
        <input id="Username" name="Username" placeholder="Enter your Username" />
        <label for="Password">Password:</label>
        <input id="Password" name="Password" placeholder="Enter your Password" />
        <INPUT TYPE=SUBMIT value="SUBMIT">


    <c:choose>
        <c:when test="${param.Username == 'admin' && param.Password == 'password'}">
            <c:redirect url="./profile.jsp">
            <p>You are admin</p>
        </c:redirect>
        </c:when>
        <c:otherwise>
<%--            <p>You Failed</p>--%>
        </c:otherwise>
    </c:choose>



<%--<%--%>
<%--    String Username = request.getParameter("Username");--%>
<%--    String Password = request.getParameter("Password");--%>
<%--    if (Username == "admin" && Password == "password"){--%>
<%--    String redirectUrl = "http://localhost:8080/profile.jsp";--%>
<%--    response.sendRedirect(redirectUrl);--%>
<%--    }else{%>--%>
<%--    <br>Error! You are an INVALID USER<br/>--%>
<%--    <%}%>--%>

<%--<c:set var="email" value="<%=Username %>"/>--%>
<%--<c:set var="password" value="<%=Password %>"/>--%>


</form>
</div>
</body>


<!-- this is an HTML comment, you *will* see this in the html -->


</html>