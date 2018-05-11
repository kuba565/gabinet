<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet</title>
</head>
<body>
<a href="/"><button>Homepage</button></a>
<br>
<c:if test="${sessionScope.adminUsername==null}">
    <a href="/admin/login"><button>Login</button></a> | <a href="/admin/registration"><button>Register</button></a>
</c:if>
<c:if test="${sessionScope.adminUsername!=null}">
    <a href="/admin/logout">
        <button style="position: absolute;top: 0px;right: 0px;">Logout</button>
    </a>

    <h1>${patient.name} ${patient.lastName}</h1>
    <h2>Historia choroby</h2>
    <br>
    <form method="post">
        <label>
            <button type="submit">zapisz zmiany</button>
            <br>
            <textarea name="medicalhistory" rows="30" cols="100">${patient.medicalHistory}</textarea>
        </label>

    </form>
</c:if>
</body>
</html>
