<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet 1.0</title>
</head>
<body>

<c:if test="${sessionScope.adminUsername==null}">
    <a href="/admin/login">Login</a>
    <a href="/admin/registration">Register</a>
</c:if>

<c:if test="${sessionScope.adminUsername!=null}">
    <h1>Witaj ${sessionScope.adminUsername}</h1>
</c:if>
</body>
</html>
