<%--
  Created by IntelliJ IDEA.
  User: AndrewBall
  Date: 4/22/20
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Product Show Page"/>
    </jsp:include>

</head>
<body>
 <!-- This is where the content for the Product Show page will go -->
<jsp:include page="../partials/navbar.jsp"/>
<div class="container">
<%--    title of the product--%>
    <h1>Current Product: ${product.title}</h1>
<%--    price of the product--%>
    <p>Price: $${product.priceInCents/100}</p>
<%--    description of product--%>
    <h3>Description</h3>
    <p>${product.description}</p>
</div>
</body>
</html>
