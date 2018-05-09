<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Homepage</a>
<br>
<c:if test="${sessionScope.adminUsername==null}">
    <a href="/admin/login">Login</a> | <a href="/admin/registration">Register</a>
</c:if>

<c:if test="${sessionScope.adminUsername!=null}">
    <a href="admin/logout">
        <button style="position: absolute;top: 0px;right: 0px;">Logout</button>
    </a>

    <table>
        <tr>
            <td>imię</td>
            <td>nazwisko</td>
            <td>data urodzenia</td>
            <td>PESEL</td>
            <td>Numer telefonu</td>
            <td>Adres</td>
        </tr>



        <tr><%--@elvariable id="patient" type="pl.coderslab.model.Patient"--%>
            <td>${patient.name}</td>
            <td>${patient.lastName}</td>
            <td>${patient.birthDate}</td>
            <td>${patient.pesel}</td>
            <td>${patient.phoneNumber}</td>
            <td>${patient.address}</td>
            <td><a href="/patient/visit/add/${patient.id}">
                <button>Dodaj wizytę</button>
            </a></td>
            <td><a href="/patient/delete/${patient.id}">
                <button>delete</button>
            </a></td>
        </tr>
    </table>
    <br>
    <a href="/patient/info/edit-history/${patient.id}">
        <button>przejdź do edycji historii choroby</button>
    </a>

    <form method="post">
        <label>
            <textarea name="medicalhistory" rows="50" cols="100" readonly>${patient.medicalHistory}</textarea>
        </label>
    </form>
    <br>


</c:if>
</body>
</html>
