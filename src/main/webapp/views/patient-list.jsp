<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet</title>
    <style>
        table, td, th, tr {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th {
            background-color: #ccc;
        }
    </style>
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
    <h2>Lista pacjentów</h2>
    <br>
    <table>
        <tr>
            <td>imię</td>
            <td>nazwisko</td>
            <td>data urodzenia</td>
        </tr>
            <%--@elvariable id="patient" type="pl.coderslab.model.Patient"--%>
        <c:forEach items="${patientsList}" var="patient">
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
