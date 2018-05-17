<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<a href="/">
    <button>Strona główna</button>
</a>
<h2>Logowanie</h2>
<br>
<%--@elvariable id="admin" type="pl.coderslab.model.Admin"--%>
<form:form modelAttribute="admin">

    <label for="login">Nazwa uzytkownika:</label>
    <br>
    <form:input path="login"/>
    <br>
    <label for="password">Haslo:</label>
    <br>
    <form:password path="password"/>
    <br>

    <button type="submit">Zaloguj</button>
    <br>


</form:form>
<c:if test="${sessionScope.loginInfo.length() > 0}">
    <p class="error">${sessionScope.loginInfo}</p>
</c:if>
</body>
</html>
