<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet</title>
</head>
<body>
<a href="/">Homepage</a>
<a href="admin/logout">
    <button style="position: absolute;top: 0px;right: 0px;">Logout</button>
</a>

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
    <label for="name">Imie:</label>
    <br>
    <form:input path="name"/>
    <br>
    <label for="lastName">Nazwisko:</label>
    <br>
    <form:input path="lastName"/>
    <br>

    <button type="submit">Zarejestruj</button>
    <br>
    <form:errors path="*"/>
</form:form>
</body>

</body>
</html>
