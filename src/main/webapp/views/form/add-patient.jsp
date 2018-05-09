<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="/">Homepage</a>
<a href="admin/logout">
    <button style="position: absolute;top: 0px;right: 0px;">Logout</button>
</a>
<%--@elvariable id="patient" type="pl.coderslab.model.Patient"--%>
<form:form modelAttribute="patient">

    <label for="name">Imię:</label>
    <br>
    <form:input path="name"/>
    <br>

    <label for="lastName">Nazwisko:</label>
    <br>
    <form:input path="lastName"/>
    <br>

    <label for="birthDateString">Data urodzenia:</label>
    <br>
    <form:input type="date" path="birthDateString"/>
    <br>

    <button type="submit">Zarejestruj</button>
    <br>
    <form:errors path="*"/>
</form:form>

</body>
</html>
