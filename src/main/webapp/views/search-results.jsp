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
    <table>
        <tr>
            <td>imię</td>
            <td>nazwisko</td>
            <td>data urodzenia</td>
        </tr>
            <%--@elvariable id="patient" type="pl.coderslab.model.Patient"--%>
        <c:forEach items="${sessionScope.searchResults}" var="patient">
            <tr>
                <td>${patient.name}</td>
                <td>${patient.lastName}</td>
                <td>${patient.birthDate}</td>
                <td><a href="/patient/info/${patient.id}">
                    <button>info</button>
                </a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
