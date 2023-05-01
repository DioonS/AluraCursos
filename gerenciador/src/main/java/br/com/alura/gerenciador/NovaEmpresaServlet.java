package br.com.alura.gerenciador;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "novaEmpresa", value = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    /*private String message;

    public void init() {
        message = "Hello World!";
    }*/

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.setContentType("text/html");

        System.out.println("Cadastrando nova empresa");

        String nomeEmpresa = request.getParameter("nome");

        PrintWriter out = response.getWriter();
        out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com Sucesso !</body></html>");
    }

/*    public void destroy() {
    }*/
}