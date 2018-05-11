<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet</title>
</head>
<body>
<a href="/"><button>Homepage</button></a>
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
    <form:errors path="*"/>
</form:form>
</body>
</html>
