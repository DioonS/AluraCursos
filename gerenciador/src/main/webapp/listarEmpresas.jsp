<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Java Standar Taglib</title>
</head>
<body>

    <p>Lista de Empresas: </p>
    <ul>
        <c:forEach items="${ empresas }" var="empresa">
            <li> ${ empresa.nome } </li>
        </c:forEach>
    </ul>

</body>
</html>
