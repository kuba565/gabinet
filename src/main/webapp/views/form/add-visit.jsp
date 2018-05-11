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

    <h2>Dodaj wizytę</h2>
    <p>${patient.name} ${patient.lastName}</p>
    <br>
    <form method="post">
        <label>
            <input type="date" name="nextVisitDateString">
            <input type="time" name="nextVisitHourString">
            <button type="submit">zapisz wizytę</button>
        </label>
        <br>
    </form>
</c:if>
</body>
</html>
