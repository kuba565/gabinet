<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wirtualny Gabinet</title>
</head>
<body>

<c:if test="${sessionScope.adminUsername==null}">
    <a href="/admin/login"><button>Login</button></a> | <a href="/admin/registration"><button>Register</button></a>
</c:if>

<c:if test="${sessionScope.adminUsername!=null}">
    <h1>Witaj ${sessionScope.admin.name}</h1>
    <a href="/admin/logout">
        <button style="position: absolute;top: 0px;right: 0px;">Logout</button>
    </a>
    <br>
    <a href="patient/add"><button>dodaj pacjenta</button></a> | <a
        href="patient/list"><button>wyświetl listę pacjentów</button></a> | <a
        href="patient/search"><button>szukaj pacjenta</button></a> | <a
        href="visit/list"><button>następne wizyty</button></a>
</c:if>
</body>
</html>
