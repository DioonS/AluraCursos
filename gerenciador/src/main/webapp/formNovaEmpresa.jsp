<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="${ linkServletNovaEmpresa }" method="post">

        <p>Nome:</p><input type="text" name="nome"/>
        <p>Data Abertura:</p><input type="text" name="data"/>

        <input type="submit"/>
    </form>
</body>
</html>