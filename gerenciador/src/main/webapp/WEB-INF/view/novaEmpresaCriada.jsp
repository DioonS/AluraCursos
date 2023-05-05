<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
    <body>
        <c:if test="${ not empty empresa }">
            <!-- Usando Expression Language -->
            <p>Empresa  ${ empresa } cadastrada com Sucesso !</p>
        </c:if>

        <c:if test="${ empty empresa }">
            <!-- Usando Expression Language -->
            <p>Nenhuma empresa cadastrada !</p>
        </c:if>
    </body>
</html>