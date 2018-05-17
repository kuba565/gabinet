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
<a href="/"><button>Strona główna</button></a>
<br>
<c:if test="${sessionScope.adminUsername==null}">
    <a href="/admin/login"><button>Logowanie</button></a> | <a href="/admin/registration"><button>Rejestracja</button></a>
</c:if>

<c:if test="${sessionScope.adminUsername!=null}">

    <a href="/admin/logout">
        <button style="position: absolute;top: 0px;right: 0px;">Wyloguj</button>
    </a>
    <h2>Wyniki wyszukiwania</h2>
    <br>
    <c:if test="${sessionScope.searchResults.size()>0}">

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
    <hr>
    ilość znalezionych elementów: ${sessionScope.searchResults.size()}
    <hr>
</c:if>
</body>
</html>
