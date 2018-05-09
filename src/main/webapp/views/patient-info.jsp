<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Homepage</a>
<a href="admin/logout">
    <button style="position: absolute;top: 0px;right: 0px;">Logout</button>
</a>

<table>
    <tr>
        <td>imię</td>
        <td>nazwisko</td>
        <td>data urodzenia</td>
        <td>historia choroby</td>
    </tr>


    <%--@elvariable id="patient" type="pl.coderslab.model.Patient"--%>
    <tr>
        <td>${patient.name}</td>
        <td>${patient.lastName}</td>
        <td>${patient.birthDate}</td>
        <td>${patient.medicalHistory}</td>
        <td><a href="/patient/delete/${patient.id}">
            <button>delete</button>
        </a></td>
    </tr>
</table>
</body>
</html>
