<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet</title>
</head>
<body><a href="/">Homepage</a>
<c:if test="${sessionScope.adminUsername==null}">
    <a href="/admin/login">Login</a> | <a href="/admin/registration">Register</a>
</c:if>

<c:if test="${sessionScope.adminUsername!=null}">
    <a href="/admin/logout">
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

        <label for="pesel">Pesel:</label>
        <br>
        <form:input type="number" path="pesel"/>
        <br>
        <button type="submit">Szukaj</button>
    </form:form>
</c:if>
</body>
</html>
