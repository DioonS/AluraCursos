<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // Scriplet para reconlher as empresas criadas no servlet
    String nomeEmpresa = (String)request.getAttribute("empresa");
    System.out.println(nomeEmpresa);
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

  <p>Empresa  <%= nomeEmpresa %> cadastrada com Sucesso !</p>

</body>
</html>