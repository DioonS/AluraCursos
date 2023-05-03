<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/alterarEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="${ linkServletNovaEmpresa }" method="post">

        <p>Nome:</p><input type="text" name="nome" value="${ empresa.nome }"/>
        <p>Data Abertura:</p><input type="text" name="data" value=<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>>
        <input type="hidden" name="id" value="${ empresa.id }"/>

        <input type="submit"/>
    </form>
</body>
</html>