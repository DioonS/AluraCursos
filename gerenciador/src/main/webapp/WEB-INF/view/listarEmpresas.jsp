<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Java Standar Taglib</title>
</head>
<body>

    <c:if test="${ not empty empresa }">
        <!-- Usando Expression Language -->
        <p>Empresa  ${ empresa } cadastrada com Sucesso !</p>
    </c:if>

    <p>Lista de Empresas: </p>
    <ul>
        <c:forEach items="${ empresas }" var="empresa">
            <li>
                    ${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
                        <a href="/gerenciador/entrada?acao=MostrarEmpresa&id=${ empresa.id }">Editar</a>
                        <a href="/gerenciador/entrada?acao=RemoverEmpresa&id=${ empresa.id }">Remover</a>
            </li>
        </c:forEach>
    </ul>

</body>
</html>
