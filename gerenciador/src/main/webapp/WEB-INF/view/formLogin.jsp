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

        <p>Nome:</p><input type="text" name="login"/>
        <p>Senha:</p><input type="password" name="senha"/>
        <input type="hidden" name="acao" value="Login">

        <input type="submit"/>
    </form>
</body>
</html>