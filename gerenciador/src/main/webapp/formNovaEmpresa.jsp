<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="${ linkEntradaServlet }" method="post">

        <p>Nome:</p><input type="text" name="nome"/>
        <p>Data Abertura:</p><input type="text" name="data"/>
        <input type="hidden" name="acao" value="NovaEmpresa">

        <input type="submit"/>
    </form>
</body>
</html>