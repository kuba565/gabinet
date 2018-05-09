<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet</title>
</head>
<body>

<c:if test="${sessionScope.adminUsername==null}">
    <a href="/admin/login">Login</a> | <a href="/admin/registration">Register</a>
</c:if>

<c:if test="${sessionScope.adminUsername!=null}">
    <h1>Witaj ${sessionScope.adminUsername}</h1>
    <a href="/admin/logout">
        <button style="position: absolute;top: 0px;right: 0px;">Logout</button>
    </a>
    <br>
    <a href="patient/add">dodaj pacjenta</a> | <a
        href="patient/list">wyświetl listę pacjentów</a> | <a
        href="patient/search">szukaj pacjenta</a> | <a
        href="patient/visit/list">następne wizyty</a>
</c:if>
</body>
</html>
