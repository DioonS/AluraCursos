<%@ page import="br.com.alura.gerenciador.servlet.Empresa" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <p>Lista de Empresas: </p>
    <br>
    <ul>

        <%
            List<Empresa> lista = (List<Empresa>)request.getAttribute("empresa");
            if (lista != null) {
                for (Empresa empresa : lista) {
        %>
        <li><%= empresa.getNome()%></li>
        <%
                }
            }
        %>

    </ul>

</body>
</html>
