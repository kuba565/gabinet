<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Homepage</a>
<br>

<%--@elvariable id="admin" type="pl.coderslab.model.Admin"--%>
<form:form modelAttribute="admin">
    <form:errors path="*"/>

    <label for="login">Nazwa użytkownika</label>
    <br>
    <form:input path="login"/>
    <br>
    <label for="password">Hasło</label>
    <br>
    <form:password path="password"/>
    <br>

    <button type="submit">Zarejestruj</button>
</form:form>
</body>

</body>
</html>
