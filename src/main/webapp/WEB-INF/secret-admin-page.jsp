<%--
  Created by IntelliJ IDEA.
  User: AndrewBall
  Date: 4/25/20
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Secret Admin Page</title>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />

<h1>Secret Admin Page</h1>
<p>Hello, ${UserName}</p>



</body>
</html>
