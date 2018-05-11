<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<a href="/"><button>Homepage</button></a> | <a href="/patient/list"><button>Lista pacjentów</button></a>
<br>
<c:if test="${sessionScope.adminUsername==null}">
    <a href="/admin/login"><button>Login</button></a> | <a href="/admin/registration"><button>Register</button></a>
</c:if>

<c:if test="${sessionScope.adminUsername!=null}">
    <a href="/admin/logout">
        <button style="position: absolute;top: 0px;right: 0px;">Logout</button>
    </a>
    <h2>Informacje o pacjencie</h2>
<br>
    <table>
        <tr>
            <td>imię</td>
            <td>nazwisko</td>
            <td>data urodzenia</td>
            <td>PESEL</td>
            <td>Numer telefonu</td>
            <td>Adres</td>
            <td>Następna wizyta</td>
        </tr>



        <tr><%--@elvariable id="patient" type="pl.coderslab.model.Patient"--%>
            <td>${patient.name}</td>
            <td>${patient.lastName}</td>
            <td>${patient.birthDate}</td>
            <td>${patient.pesel}</td>
            <td>${patient.phoneNumber}</td>
            <td>${patient.address}</td>
            <td>${patient.nextVisitDateString} ${patient.nextVisitHourString}</td>
            <td><a href="/patient/info/${patient.id}/add-visit">
                <button>Dodaj wizytę</button>
            </a></td>
            <td><a href="/patient/delete/${patient.id}">
                <button>usuń</button>
            </a></td>
            <td><a href="/patient/edit/${patient.id}">
                <button>edytuj</button>
            </a></td>
        </tr>
    </table>
    <br>
    <a href="/patient/info/edit-history/${patient.id}">
        <button>przejdź do edycji historii choroby</button>
    </a>

    <form method="post">
        <label>
            <textarea name="medicalhistory" rows="25" cols="100" readonly>${patient.medicalHistory}</textarea>
        </label>
    </form>
    <br>


</c:if>
</body>
</html>
