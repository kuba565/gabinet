<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet</title>
</head>
<body>
<a href="/">Homepage</a>
<br>
<c:if test="${sessionScope.adminUsername==null}">
    <a href="/admin/login">Login</a> | <a href="/admin/registration">Register</a>
</c:if>
<c:if test="${sessionScope.adminUsername!=null}">
    <a href="/admin/logout">
        <button style="position: absolute;top: 0px;right: 0px;">Logout</button>
    </a>

    <h1>${patient.name} ${patient.lastName}</h1>

    <br>
    <form method="post">
        <label>
            <button type="submit">zapisz zmiany</button>
            <br>
            <textarea name="medicalhistory" rows="50" cols="100">${patient.medicalHistory}</textarea>
        </label>

    </form>
</c:if>
</body>
</html>
