<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet</title>
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
    <h2>Edytuj pacjenta:</h2>
    <br>
    <%--@elvariable id="patient" type="pl.coderslab.model.Patient"--%>
    <form:form modelAttribute="patientToBeEdited">

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

        <label for="pesel">Pesel:</label>
        <br>
        <form:input type="number" path="pesel"/>
        <br>

        <label for="phoneNumber">Numer telefonu:</label>
        <br>
        <form:input type="number" path="phoneNumber"/>
        <br>

        <label for="address">Adres:</label>
        <br>
        <form:input type="text" path="address"/>
        <br>

        <form:input type="hidden" path="nextVisitDateString"/>
        <form:input type="hidden" path="nextVisitHourString"/>

        <button type="submit">Zapisz zmiany</button>
        <br>
        <form:errors path="*"/>
    </form:form>
</c:if>
</body>
</html>
