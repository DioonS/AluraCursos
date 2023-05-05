<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <c:import url="logout-parcial.jsp"/>

    <form action="${ linkEntradaServlet }" method="post">

        <p>Nome:</p><input type="text" name="nome" value="${ empresa.nome }"/>
        <p>Data Abertura:</p><input type="text" name="data" value=<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>>
        <input type="hidden" name="id" value="${ empresa.id }"/>
        <input type="hidden" name="acao" value="AlterarEmpresa"/>

        <input type="submit"/>
    </form>
</body>
</html>