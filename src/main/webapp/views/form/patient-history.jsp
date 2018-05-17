<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet</title>
</head>
<body>
<a href="/"><button>Strona główna</button></a>
<br>
<c:if test="${sessionScope.adminUsername==null}">
    <a href="/admin/login"><button>Logowanie</button></a> | <a href="/admin/registration"><button>Rejestracja</button></a>
</c:if>

<c:if test="${sessionScope.adminUsername!=null}">

    <a href="/admin/logout">
        <button style="position: absolute;top: 0px;right: 0px;">Wyloguj</button>
    </a>

    <h1>${patient.name} ${patient.lastName}</h1>
    <h2>Historia choroby</h2>
    <br>
    <form method="post">
        <label>
            <button type="submit">zapisz zmiany</button>
            <br>
            <textarea name="medicalhistory" rows="25" cols="100">${patient.medicalHistory}</textarea>
        </label>

    </form>
</c:if>
</body>
</html>
