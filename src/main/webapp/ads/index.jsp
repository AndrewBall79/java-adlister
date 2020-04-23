<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="View Our Ads" />
    </jsp:include>
</head>
<body>

<%--loop through the array of ads--%>
<div class="container">
<c:forEach var="ad" items="${allTheAds}">
    <h1><c:out value="${ad.title}" /></h1>
    <p><c:out value="${ad.description}"/></p>
</c:forEach>

</div>
</body>
</html>
